package com.alegerd.controller;

import com.alegerd.service.PostManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
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

    public void setUserService(PostManagerService postManagerService) {
        this.postManagerService = postManagerService;
    }
}
