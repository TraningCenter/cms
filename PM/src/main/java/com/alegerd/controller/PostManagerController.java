package com.alegerd.controller;

import com.alegerd.service.PostManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/pm")
public class PostManagerController {

    @Autowired
    PostManagerService postManagerService;

    @RequestMapping(
            value = "/postsOfUser/{userId}",
            method = RequestMethod.GET)
    public ResponseEntity home(@PathVariable Integer userId){
        return new ResponseEntity(postManagerService.getAllPostsByUserId(userId), HttpStatus.OK);
    }

    public void setUserService(PostManagerService postManagerService) {
        this.postManagerService = postManagerService;
    }
}
