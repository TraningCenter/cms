package views;

import dto.PostDto;
import model.PostsService;
import util.PMConnector;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserPostsView {

    @Inject
    private PostsService service;

    @PostConstruct
    public void init(){

    }

    public List<PostDto> getAllUserPosts(){
        try {
            String username = LoginView.user.getUsername();
            List<PostDto> posts = service.getAllUserPosts(username);
            return reverse(posts);
        }catch (IOException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private List<PostDto> reverse(List<PostDto> posts){
        List<PostDto> result = new ArrayList<>();
        for(int i = posts.size()-1; i >= 0; i--){
            result.add(posts.get(i));
        }
        return result;
    }

    public void setService(PostsService service) {
        this.service = service;
    }
}
