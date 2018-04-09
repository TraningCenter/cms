package com.alegerd.dto;

public class ContentDto {

    private Integer postId;
    private String content;

    public ContentDto(Integer postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
