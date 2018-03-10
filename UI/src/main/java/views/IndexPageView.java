package views;

import dto.PostDto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class IndexPageView {

    public List<PostDto> posts;

    @PostConstruct
    public void init(){
        posts = new ArrayList<>();
        posts.add(new PostDto("title", "Author's Name", "Lorem Ipsum post content"));
        posts.add(new PostDto("title2", "Author's Name2", "Lorem Ipsum post content"));
        posts.add(new PostDto("title3", "Author's Name3", "Lorem Ipsum post content"));
        posts.add(new PostDto("title4", "Author's Name4", "Lorem Ipsum post content"));
        posts.add(new PostDto("title5", "Author's Name5", "Lorem Ipsum post content"));
        posts.add(new PostDto("title6", "Author's Name6", "Lorem Ipsum post content"));
    }

    public List<PostDto> getPosts() {
        return posts;
    }
}
