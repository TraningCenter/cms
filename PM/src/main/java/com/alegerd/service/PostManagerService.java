package com.alegerd.service;

import com.alegerd.dao.UserDao;
import com.alegerd.dao.UserPostsDao;
import com.alegerd.dto.UserDto;
import com.alegerd.mappers.Mapper;
import com.alegerd.model.UserpostsEntity;
import com.alegerd.model.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostManagerService {

    @Autowired
    private UserPostsDao userPostsDao;

    @Autowired
    private UserDao userDao;

    public List<Integer> getAllPostsByUserId(Integer userId){
        List<Integer> result = new ArrayList<>();
        List<UserpostsEntity> userPostDtos = userPostsDao.getUserPostsByUserId(userId);
        userPostDtos.forEach(userpostsEntity -> result.add(userpostsEntity.getPostId().intValue()));
        return result;
    }

    @Transactional
    public void addUser(UserDto userDto){
        UsersEntity entity = Mapper.userDtoToUserEntity(userDto);
        userDao.create(entity);
    }

    @Transactional
    public UserDto getUserByUsername(String username){
        return Mapper.userEntityToUserDto(userDao.getUserByUsername(username));
    }

    @Transactional
    public String addPostToUser(String userId){
        String postId;

        UsersEntity user = userDao.getUserById(Long.parseLong(userId));
        List<UserpostsEntity> posts = user.getPosts();
        UserpostsEntity newPost = new UserpostsEntity();
        newPost.setUser(user);
        postId = userPostsDao.createAndGetId(newPost).toString();
        newPost.setPostId(Long.parseLong(postId));
        userPostsDao.update(newPost);
        posts.add(newPost);
        user.setPosts(posts);
        userDao.update(user);
        return postId;
    }

    public void setUserPostsDao(UserPostsDao userPostsDao) {
        this.userPostsDao = userPostsDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
