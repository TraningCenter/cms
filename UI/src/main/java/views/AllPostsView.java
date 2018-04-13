package views;

import dto.PostDto;
import javafx.geometry.Pos;
import model.PostsService;
import util.PMConnector;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AllPostsView {

    @Inject
    public PostsService postsService;

    @Inject
    public PMConnector pmConnector;

    public List<PostDto> posts;

    public String input;

    public String result;

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
        return reverse(posts);
    }

    public void send(){
        try {
            result = pmConnector.addUser(input);
        }catch (IOException e){

        }
    }

    public void addPost(PostDto newPost){
        postsService.addPost(newPost);
    }

    private List<PostDto> reverse(List<PostDto> posts){
        List<PostDto> result = new ArrayList<>();
        for(int i = posts.size()-1; i >= 0; i--){
            result.add(posts.get(i));
        }
        return result;
    }

    public List<PostDto> getPosts() {
        posts = postsService.getPosts();
        return posts;
    }

    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setPmConnector(PMConnector pmConnector) {
        this.pmConnector = pmConnector;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
