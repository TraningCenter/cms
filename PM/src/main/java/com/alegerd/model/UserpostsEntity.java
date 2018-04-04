package com.alegerd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userposts", schema = "public", catalog = "pm")
public class UserpostsEntity {
    private int id;
    private Integer userId;
    private Integer postId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "post_id")
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserpostsEntity that = (UserpostsEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, postId);
    }
}
