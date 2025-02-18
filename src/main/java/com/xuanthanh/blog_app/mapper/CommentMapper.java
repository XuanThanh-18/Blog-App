package com.xuanthanh.blog_app.mapper;

import com.xuanthanh.blog_app.dto.CommentDto;
import com.xuanthanh.blog_app.entity.Comment;
import com.xuanthanh.blog_app.form.CommentCreateForm;
import com.xuanthanh.blog_app.form.CommentUpdateForm;

public class CommentMapper {
    public static CommentDto map(Comment comment){
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        dto.setUpdatedAt(comment.getUpdatedAt());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }
    public static Comment map(CommentCreateForm form){
        var comment = new Comment();
        comment.setBody(form.getBody());
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        return comment;
    }
    public static void map(CommentUpdateForm form,Comment comment){
        comment.setEmail(form.getEmail());
        comment.setName(form.getName());
        comment.setBody(form.getBody());
    }
}
