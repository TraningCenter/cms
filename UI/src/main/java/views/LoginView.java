package views;

import com.google.gson.Gson;
import dto.UserDto;
import model.PostsService;
import util.PMConnector;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.IOException;

@ManagedBean
@SessionScoped
public class LoginView {

    public static UserDto user;

    @Inject
    private PMConnector connector;

    @PostConstruct
    public void init(){
        user = new UserDto();
    }

    public String login(){
        try {
            Gson gson = new Gson();
            String userDto = connector.addUser(user.getUsername());
            UserDto user = gson.fromJson(userDto, UserDto.class);
            this.user = user;
        }catch (IOException e){

        }
        return "allPostsPage.xhtml?faces-redirect=true";
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public void setConnector(PMConnector connector) {
        this.connector = connector;
    }
}
