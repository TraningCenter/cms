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

    public PostDto postDto;

    @Inject
    private PostsService postsService;

    @PostConstruct
    public void init(){
        postDto = new PostDto();
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public void findPostById(){
        try {
            postDto = postsService.findPostById(postDto.getId());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }
}
