package views;

import dto.PostDto;
import javafx.geometry.Pos;
import model.PostsService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AllPostsView {

    @Inject
    public PostsService postsService;

    public List<PostDto> posts;

    @PostConstruct
    public void init(){
        List<PostDto> posts = new ArrayList<>();
        posts.add(new PostDto("title", "Author's Name", "Lorem Ipsum post content"));
        posts.add(new PostDto("title2", "Author's Name2", "Lorem Ipsum post content"));
        posts.add(new PostDto("title3", "Author's Name3", "Lorem Ipsum post content"));
        posts.add(new PostDto("title4", "Author's Name4", "Lorem Ipsum post content"));
        posts.add(new PostDto("title5", "Author's Name5", "Lorem Ipsum post content"));
        posts.add(new PostDto("title6", "Author's Name6", "Lorem Ipsum post content"));
        postsService.setPosts(posts);
    }

    public List<PostDto> getPostsReversed(){
        posts = postsService.getPosts();
        List<PostDto> result = new ArrayList<>();
        for(int i = posts.size()-1; i >= 0; i--){
            result.add(posts.get(i));
        }
        return result;
    }

    public void addPost(PostDto newPost){
        postsService.addPost(newPost);
    }

    public List<PostDto> getPosts() {
        posts = postsService.getPosts();
        return posts;
    }
}
