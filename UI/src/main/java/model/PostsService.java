package model;

import dto.PostDto;
import dto.UserDto;
import util.PMConnector;
import views.LoginView;

import javax.ejb.Stateful;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class PostsService implements Serializable{

    List<PostDto> posts = new ArrayList<>();

    @Inject
    private PMConnector connector;

    public String addPost(PostDto post){
        String postid = "";
        try {
            UserDto user = LoginView.user;
            postid = connector.addPostToUser(user.getId().toString());
        }catch (IOException e){
            e.printStackTrace();
        }
        return postid;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setConnector(PMConnector connector) {
        this.connector = connector;
    }
}
