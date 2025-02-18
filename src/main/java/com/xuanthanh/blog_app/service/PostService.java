package com.xuanthanh.blog_app.service;

import com.xuanthanh.blog_app.dto.PostDto;
import com.xuanthanh.blog_app.form.PostCreateForm;
import com.xuanthanh.blog_app.form.PostFilterForm;
import com.xuanthanh.blog_app.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Page<PostDto> findAll(PostFilterForm form,Pageable pageable);

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Long id);

    void deleteById(Long id);

}
