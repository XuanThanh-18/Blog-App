package com.xuanthanh.blog_app.mapper;

import com.xuanthanh.blog_app.dto.PostDto;
import com.xuanthanh.blog_app.entity.Post;
import com.xuanthanh.blog_app.form.PostCreateForm;
import com.xuanthanh.blog_app.form.PostUpdateForm;

public class PostMapper {
    public static PostDto map(Post post){
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        return dto;
    }
    public static Post map(PostCreateForm form){
        var post = new Post();
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        post.setTitle(form.getTitle());
        return post;
    }
    // anh xa mot form cap nhat vao mot bai viet trong database
    public static void map(PostUpdateForm form, Post post){
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
    }
}
