package com.xuanthanh.blog_app.service;

import com.xuanthanh.blog_app.dto.PostDto;
import com.xuanthanh.blog_app.entity.Post;
import com.xuanthanh.blog_app.form.PostCreateForm;
import com.xuanthanh.blog_app.form.PostFilterForm;
import com.xuanthanh.blog_app.form.PostUpdateForm;
import com.xuanthanh.blog_app.mapper.PostMapper;
import com.xuanthanh.blog_app.repository.PostRepository;
import com.xuanthanh.blog_app.specification.PostSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("PostServiceImpl")
@AllArgsConstructor
// dat PostServiceImpl la service chinh khi ma co nhieu service trien khai PostService
@Primary
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;
    @Override
    public Page<PostDto> findAll(PostFilterForm form,Pageable pageable){
        var spec = PostSpecification.buildSpec(form);
        return postRepository.findAll(spec,pageable)
                .map(post -> modelMapper.map(post,PostDto.class));
    }
    @Override
    public PostDto findById(Long id){
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post,PostDto.class))
                .orElse(null);
    }
    @Override
    public PostDto create(PostCreateForm form){
        var post = modelMapper.map(form, Post.class);
        var savePost = postRepository.save(post);
        return modelMapper.map(savePost,PostDto.class);
    }
    @Override
    public PostDto update(PostUpdateForm form, Long id){
        var optional = postRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        var post = optional.get();
        modelMapper.map(form,post);
        var savedPost = postRepository.save(post);
        return modelMapper.map(savedPost,PostDto.class);
    }
    @Override
    public void deleteById(Long id){
        postRepository.deleteById(id);
    }
}
