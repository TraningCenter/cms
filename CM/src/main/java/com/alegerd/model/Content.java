package com.alegerd.model;

public class Content {

    private Integer id;
    private Integer post_id;
    private String post_content;

    public Content() {

    }

    public Content(Integer post_id, String post_content) {
        this.post_id = post_id;
        this.post_content = post_content;
    }

    public Content(Integer id, Integer post_id, String post_content) {
        this.id = id;
        this.post_id = post_id;
        this.post_content = post_content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return post_id;
    }

    public void setPostId(Integer postId) {
        this.post_id = postId;
    }

    public String getContent() {
        return post_content;
    }

    public void setContent(String content) {
        this.post_content = content;
    }
}
