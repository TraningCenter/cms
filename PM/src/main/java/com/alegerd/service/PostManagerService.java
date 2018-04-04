package com.alegerd.service;

import com.alegerd.dao.UserPostsDao;
import com.alegerd.model.UserpostsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostManagerService {

    @Autowired
    private UserPostsDao userPostsDao;

    public List<Integer> getAllPostsByUserId(Integer userId){
        List<Integer> result = new ArrayList<>();
        List<UserpostsEntity> userPostDtos = userPostsDao.getUserPostsByUserId(userId);
        userPostDtos.forEach(userpostsEntity -> result.add(userpostsEntity.getPostId()));
        return result;
    }

    public void setUserPostsDao(UserPostsDao userPostsDao) {
        this.userPostsDao = userPostsDao;
    }
}
