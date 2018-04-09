package com.alegerd.service;


import com.alegerd.dao.ContentDao;
import com.alegerd.dto.ContentDto;
import com.alegerd.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentDao contentDao;

    public List<String> getContentByPostId(Integer postId){
        List<Content> result = contentDao.getContentByPostId(postId);
        List<String> resDto = new LinkedList<>();
        for (Content content : result) {
            resDto.add(content.getContent());
        }
        return resDto;
    }

    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }
}
