package com.alegerd.mappers;

import com.alegerd.dto.PostDto;
import com.alegerd.dto.UserDto;
import com.alegerd.model.UserpostsEntity;
import com.alegerd.model.UsersEntity;

import java.util.LinkedList;
import java.util.List;

public class Mapper {

    public static UsersEntity userDtoToUserEntity(UserDto userDto) {

        UsersEntity ue = new UsersEntity();
        ue.setUsername(userDto.getUsername());
        return ue;
    }

    public static UserDto userEntityToUserDto(UsersEntity userEntity) {
        UserDto ud = new UserDto(userEntity.getUsername());
        List<PostDto> postDtos = new LinkedList<>();
        for (UserpostsEntity entity : userEntity.getPosts()) {
            postDtos.add(Mapper.userpostsEntityToUserpostsDto(entity));
        }
        ud.setPosts(postDtos);
        ud.setId(userEntity.getId());
        return ud;
    }

    public static UserpostsEntity userpostsDtoToUserpostEntity(PostDto postDto) {
        UserpostsEntity entity = new UserpostsEntity();
        entity.setPostId(postDto.getPostId());
        entity.setUser(Mapper.userDtoToUserEntity(postDto.getUserDto()));
        return entity;
    }

    public static PostDto userpostsEntityToUserpostsDto(UserpostsEntity entity) {
        PostDto postDto = new PostDto(entity.getPostId());
        postDto.setUserDto(Mapper.userEntityToUserDto(entity.getUser()));
        return postDto;
    }
}
