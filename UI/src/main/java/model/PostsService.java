package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.ContentDto;
import dto.PostDto;
import dto.SimplePostDto;
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

    @Inject
    private PMConnector pmConnector;

    @Inject
    private CMConnector cmConnector;

    public void addPost(PostDto post) {
        String postid;
        try {
            UserDto user = LoginView.user;
            postid = pmConnector.addPostToUser(user.getId().toString());
            cmConnector.addContentToPost(new ContentDto(Integer.parseInt(postid), post.getPost().get(0))); //todo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPartToPost(String postId, String part) throws IOException{
        cmConnector.addContentToPost(new ContentDto(Integer.parseInt(postId), part));
    }

    public List<PostDto> getAllUserPosts(String username) throws IOException {
        Gson gson = new Gson();
        Type listtype = new TypeToken<List<Integer>>() {
        }.getType();
        Type stringListType = new TypeToken<List<String>>() {
        }.getType();
        List<PostDto> result = new LinkedList<>();

        UserDto userDto = gson.fromJson(pmConnector.getUserByUsername(username), UserDto.class);
        List<Integer> postIds = gson.fromJson(pmConnector.getUserPostsByUserId(userDto.getId().toString()), listtype);
        for (Integer postId : postIds) {
            String response = cmConnector.getContentByPostId(postId.toString());
            List<String> content = gson.fromJson(response, stringListType);
            PostDto postDto = new PostDto();
            postDto.setAuthor(username);
            postDto.setId(postId.toString());
            postDto.setTitle(username + "'s post");
            postDto.setPost(content);
            result.add(postDto);
        }

        return result;
    }

    public PostDto findPostById(String id) throws IOException{
        Gson gson = new Gson();
        Type stringListType = new TypeToken<List<String>>() {
        }.getType();

        SimplePostDto post = gson.fromJson(pmConnector.getPostByPostId(id), SimplePostDto.class);
        PostDto postDto = new PostDto();
        postDto.setAuthor(post.getAuthor());
        List<String> content = gson.fromJson(cmConnector.getContentByPostId(id), stringListType);

        postDto.setId(post.getPostId().toString());
        postDto.setPost(content);
        postDto.setTitle(post.getAuthor() + "'s post");
        return postDto;
    }

    public void setCmConnector(CMConnector cmConnector) {
        this.cmConnector = cmConnector;
    }

    public List<PostDto> getPosts() throws IOException{
        Gson gson = new Gson();
        Type listPostDto = new TypeToken<List<SimplePostDto>>() {}.getType();
        Type stringListType = new TypeToken<List<String>>() {}.getType();
        List<SimplePostDto> postDtos = gson.fromJson(pmConnector.getAllPosts(), listPostDto);
        List<PostDto> result = new LinkedList<>();

        for (SimplePostDto post : postDtos) {
            String response = cmConnector.getContentByPostId(post.getPostId().toString());
            List<String> content = gson.fromJson(response, stringListType);

            PostDto postDto = new PostDto();
            postDto.setId(post.getPostId().toString());
            postDto.setAuthor(post.getAuthor());
            postDto.setTitle(post.getAuthor() + "'s post");
            postDto.setPost(content);
            result.add(postDto);
        }

        return result;
    }

    public void setPmConnector(PMConnector pmConnector) {
        this.pmConnector = pmConnector;
    }
}
