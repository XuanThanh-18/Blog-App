package com.xuanthanh.blog_app.service;

import com.xuanthanh.blog_app.dto.CommentDto;
import com.xuanthanh.blog_app.form.CommentCreateForm;
import com.xuanthanh.blog_app.form.CommentFilterFrom;
import com.xuanthanh.blog_app.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDto> findAll(CommentFilterFrom form ,Pageable pageable);
    Page<CommentDto> findByPostId(Long postId,Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(CommentCreateForm form,long postId);

    CommentDto update(CommentUpdateForm form, Long id);

    void deleteById(Long id);
    void deleteAllByPostId(Long postId);
}
