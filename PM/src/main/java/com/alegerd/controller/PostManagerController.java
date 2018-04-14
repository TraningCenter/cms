package com.alegerd.controller;

import com.alegerd.dto.PostDto;
import com.alegerd.dto.UserDto;
import com.alegerd.service.PostManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class PostManagerController {

    @Autowired
    PostManagerService postManagerService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> test(@PathVariable Integer userId){
        return postManagerService.getAllPostsByUserId(userId.toString());
    }

    @RequestMapping(value = "/getPost/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public PostDto getPostByPostId(@PathVariable String postId){
        PostDto postDto = postManagerService.getPostByPostId(postId);
        return postDto;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody String username){
        postManagerService.addUser(new UserDto(username));
    }

    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET )
    @ResponseBody
    public UserDto getUserByUsername(@PathVariable String username){
        UserDto userDto = postManagerService.getUserByUsername(username);
        return userDto;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<PostDto> getAllPosts(){
        List<PostDto> posts = postManagerService.getAllPosts();

        //TODO
        if(posts.size() > 12)
            posts = posts.subList(posts.size()-11, posts.size());
        return posts;
    }

    @RequestMapping(value = "/addPostToUser/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(@PathVariable String userId){
        return postManagerService.addPostToUser(userId);
    }

    public void setUserService(PostManagerService postManagerService) {
        this.postManagerService = postManagerService;
    }
}
