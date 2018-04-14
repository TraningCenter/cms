package views;

import dto.PostDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@SessionScoped
public class NewPostView {

    private String newPostContent;

    @ManagedProperty("#{allPostsView}")
    private AllPostsView postsView;

    @ManagedProperty("#{loginView}")
    private LoginView loginView;

    public String makeNewPost(){
        List<String> content = new LinkedList<>();
        content.add(newPostContent);
        PostDto newPost = new PostDto("Custom Title", loginView.getUser().getUsername(), content); //todo
        postsView.addPost(newPost);
        return "allPostsPage.xhtml?faces-redirect=true";
    }

    public String getNewPostContent() {
        return newPostContent;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setPostsView(AllPostsView postsView) {
        this.postsView = postsView;
    }

    public void setNewPostContent(String newPostContent) {
        this.newPostContent = newPostContent;
    }
}
