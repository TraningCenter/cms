package views;

import dto.PostDto;
import dto.SimplePostDto;
import javafx.geometry.Pos;
import model.PostsService;
import util.PMConnector;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AllPostsView {

    @Inject
    public PostsService postsService;

    @Inject
    public PMConnector pmConnector;

    public String input;

    public String result;

    @PostConstruct
    public void init(){
    }

    public List<PostDto> getPostsReversed(){
        try {
            List<PostDto> posts = postsService.getPosts();
            return reverse(posts);
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
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
