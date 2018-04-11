package com.alegerd.dto;

public class PostDto {

    public Long postId;

    public UserDto userDto;

    public PostDto(Long postId) {
        this.postId = postId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
