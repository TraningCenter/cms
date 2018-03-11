package views;

import dto.PostDto;
import model.PostsService;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class NewPostView {

    private String newPostContent;

    @ManagedProperty("#{allPostsView}")
    private AllPostsView postsView;

    @ManagedProperty("#{loginView}")
    private LoginView loginView;

    public String makeNewPost(){
        PostDto newPost = new PostDto("Custom Title", loginView.getUsername(), newPostContent);
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
