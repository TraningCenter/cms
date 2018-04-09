package com.alegerd.dao;

import com.alegerd.model.Content;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContentDao {

    @Select("SELECT id, post_id, post_content FROM postcontent WHERE post_id = #{postId};")
    public List<Content> getContentByPostId(Integer postId);
}
