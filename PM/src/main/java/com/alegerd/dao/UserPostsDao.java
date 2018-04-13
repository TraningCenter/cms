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

    public List<UserpostsEntity> getUserPostsByUserId(Long userId){
        Query query = getManager().createQuery("select u from UserpostsEntity u where u.user.id=:userId")
                .setParameter("userId", userId);
        return query.getResultList();
    }

    public List<UserpostsEntity> getAllPosts(){
        Query query = getManager().createQuery("select u from UserpostsEntity u ");
        return query.getResultList();
    }

    public Long createAndGetId(UserpostsEntity entity){
        create(entity);
        return entity.getId();
    }
}
