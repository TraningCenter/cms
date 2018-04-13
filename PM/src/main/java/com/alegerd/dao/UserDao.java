package com.alegerd.dao;

import com.alegerd.model.UsersEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao extends GenericDao<UsersEntity, Integer>{

    public UserDao() {
        super(UsersEntity.class);
    }

    public UsersEntity getUserByUsername(String username){
        Query query = getManager().createQuery("select u from UsersEntity u where u.username=:username")
                .setParameter("username", username);
        List<UsersEntity> result = query.getResultList();
        return result.get(0);
    }

    public UsersEntity getUserById(Long id){
        Query query = getManager().createQuery("select u from UsersEntity u where u.id=:id")
                .setParameter("id", id);
        List<UsersEntity> result = query.getResultList();
        return result.get(0);
    }

    public boolean isUserExists(String username){
        Query query = getManager().createQuery("select u from UsersEntity u where u.username=:username")
                .setParameter("username", username);
        List<UsersEntity> result = query.getResultList();
        return result.size() != 0? true : false;
    }
}
