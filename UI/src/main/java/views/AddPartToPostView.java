package views;

import dto.PostDto;
import model.PostsService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@ManagedBean
@ViewScoped
public class AddPartToPostView {

    @Inject
    private PostsService postsService;

    public PostDto postDto;

    public String newPartContent;

    public boolean isAuthor;

    @PostConstruct
    public void init(){
        postDto = new PostDto();
    }

    public void findPostById(){
        try {
            String username = LoginView.user.getUsername();
            postDto = postsService.findPostById(postDto.getId());
            if(username != null && username.equals(postDto.getAuthor())) {
                isAuthor = true;
            }
            else {
                isAuthor = false;
                FacesContext.getCurrentInstance().getExternalContext().redirect("userPostsPage.xhtml");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addPart(){
        try {
            List<String> parts = postDto.getPost();
            parts.add(newPartContent);
            postDto.setPost(parts);
            postsService.addPartToPost(postDto.getId(), newPartContent);
            FacesContext.getCurrentInstance().getExternalContext().redirect("addPartToPostPage.xhtml?id=" + postDto.getId());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    public String getNewPartContent() {
        return newPartContent;
    }

    public void setNewPartContent(String newPartContent) {
        this.newPartContent = newPartContent;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }
}
