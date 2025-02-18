package com.xuanthanh.blog_app.service;

import com.xuanthanh.blog_app.dto.PostDto;
import com.xuanthanh.blog_app.form.PostCreateForm;
import com.xuanthanh.blog_app.form.PostFilterForm;
import com.xuanthanh.blog_app.form.PostUpdateForm;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("PostServiceImplV2")
public class PostServiceImplV2 implements PostService{
    @Override
    public Page<PostDto> findAll(PostFilterForm form,Pageable pageable) {
        return null;
    }

    @Override
    public PostDto findById(Long id) {
        return null;
    }

    @Override
    public PostDto create(PostCreateForm form) {
        return null;
    }

    @Override
    public PostDto update(PostUpdateForm form, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
