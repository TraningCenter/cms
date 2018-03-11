package model;

import dto.PostDto;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class PostsService implements Serializable{

    List<PostDto> posts = new ArrayList<>();

    public void addPost(PostDto post){
        posts.add(post);
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPosts() {
        return posts;
    }
}
