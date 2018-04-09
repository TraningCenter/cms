package com.alegerd.controller;

import com.alegerd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class ContentManagerController {

    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public List<String> test(@PathVariable Integer postId){
        return contentService.getContentByPostId(postId);
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }
}
