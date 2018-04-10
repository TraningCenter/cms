package com.alegerd.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users", schema = "public", catalog = "pm")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
