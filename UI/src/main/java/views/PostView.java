package views;

import dto.PostDto;
import dto.SimplePostDto;
import model.PostsService;
import org.omg.CORBA.INTERNAL;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.IOException;

@ManagedBean
@ViewScoped
public class PostView {

    public SimplePostDto spd;

    public PostDto postDto;

    @Inject
    private PostsService postsService;

    @PostConstruct
    public void init(){
        spd = new SimplePostDto();
        postDto = new PostDto();
    }

    public SimplePostDto getSpd() {
        return spd;
    }

    public void setSpd(SimplePostDto spd) {
        this.spd = spd;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public void findPostById(){
        try {
            postDto = postsService.findPostById(spd.getPostId().toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }
}
