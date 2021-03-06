package com.alegerd.controller;

import com.alegerd.dto.ContentDto;
import com.alegerd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/addContent", method = RequestMethod.POST, consumes = "application/json")
    public void addContent(@RequestBody ContentDto contentDto){
        contentService.addContent(contentDto);
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }
}
