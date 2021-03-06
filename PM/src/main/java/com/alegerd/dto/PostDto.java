package com.alegerd.dto;

public class PostDto {

    public Long postId;

    public String author;

    public PostDto(Long postId, String author) {
        this.postId = postId;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
