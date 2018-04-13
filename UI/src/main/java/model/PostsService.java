package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.ContentDto;
import dto.PostDto;
import dto.UserDto;
import util.CMConnector;
import util.PMConnector;
import views.LoginView;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Stateful
public class PostsService implements Serializable {

    List<PostDto> posts = new ArrayList<>();

    @Inject
    private PMConnector pmConnector;

    @Inject
    private CMConnector cmConnector;

    public void addPost(PostDto post) {
        String postid;
        try {
            UserDto user = LoginView.user;
            postid = pmConnector.addPostToUser(user.getId().toString());
            cmConnector.addContentToPost(new ContentDto(Integer.parseInt(postid), post.getPost()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PostDto> getAllUserPosts(String username) throws IOException{
        Gson gson = new Gson();
        Type listtype = new TypeToken<List<Integer>>(){}.getType();
        Type stringListType = new TypeToken<List<String>>(){}.getType();
        List<PostDto> result = new LinkedList<>();

        UserDto userDto = gson.fromJson(pmConnector.getUserByUsername(username), UserDto.class);
        List<Integer> postIds = gson.fromJson(pmConnector.getUserPostsByUserId(userDto.getId().toString()), listtype);
        for (Integer postId: postIds) {
            String response = cmConnector.getContentByPostId(postId.toString());
            List<String> content = gson.fromJson(response, stringListType);

            String res = "";              //TODO
            for (String item: content) {
                res += item;
            }

            PostDto postDto = new PostDto();
            postDto.setAuthor(username);
            postDto.setTitle(username + "'s post");
            postDto.setPost(res);
            result.add(postDto);
        }

        return result;
    }

    public void setCmConnector(CMConnector cmConnector) {
        this.cmConnector = cmConnector;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPmConnector(PMConnector pmConnector) {
        this.pmConnector = pmConnector;
    }
}
