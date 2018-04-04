package com.alegerd.dao;

import com.alegerd.model.UserpostsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserPostsDao extends GenericDao<UserpostsEntity, Integer>{

    public UserPostsDao() {
        super(UserpostsEntity.class);
    }

    public List<UserpostsEntity> getUserPostsByUserId(Integer userId){
        Query query = getManager().createQuery("select u from UserpostsEntity u");
        return query.getResultList();
    }
}
