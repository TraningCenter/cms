package com.alegerd.util;

import com.alegerd.dto.ContentDto;
import com.alegerd.model.Content;

public class Mapper {

    public static ContentDto contentEntityToContentDto(Content entity){
        ContentDto content = new ContentDto();
        content.setPostId(entity.getPostId());
        content.setContent(entity.getContent());
        return content;
    }

    public static Content contentDtoToContentEntity(ContentDto dto){
        return new Content(dto.getPostId(), dto.getContent());
    }
}

