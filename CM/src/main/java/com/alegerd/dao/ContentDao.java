package com.alegerd.dao;

import com.alegerd.model.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContentDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "post_id", column = "post_id"),
            @Result(property = "post_content", column = "post_content")
    })

    @Select("SELECT id, post_id, post_content FROM postcontent WHERE post_id = #{postId};")
    public List<Content> getContentByPostId(Integer postId);

    @Insert("INSERT INTO postcontent(post_id, post_content) VALUES (#{post_id}, #{post_content})")
    public void addContent(Content content);
}
