package com.alegerd.controller;

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
        return postManagerService.getAllPostsByUserId(userId);
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody String username){
        postManagerService.addUser(new UserDto(username));
    }

    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET )
    @ResponseBody
    public UserDto getUserByUsername(@PathVariable String username){
        return postManagerService.getUserByUsername(username);
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
