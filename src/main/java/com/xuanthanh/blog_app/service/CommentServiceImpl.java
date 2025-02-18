package com.xuanthanh.blog_app.service;

import com.xuanthanh.blog_app.dto.CommentDto;
import com.xuanthanh.blog_app.form.CommentCreateForm;
import com.xuanthanh.blog_app.form.CommentFilterFrom;
import com.xuanthanh.blog_app.form.CommentUpdateForm;
import com.xuanthanh.blog_app.mapper.CommentMapper;
import com.xuanthanh.blog_app.repository.CommentRepository;
import com.xuanthanh.blog_app.repository.PostRepository;
import com.xuanthanh.blog_app.specification.CommentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    @Override
    public Page<CommentDto> findAll(CommentFilterFrom form,Pageable pageable){
        var spec = CommentSpecification.buildSpec(form);
        return commentRepository.findAll(spec,pageable)
                .map(CommentMapper::map);
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId,pageable).map(CommentMapper::map);
    }

    @Override
    public CommentDto findById(Long id){
        return commentRepository.findById(id)
                .map(CommentMapper::map)
                .orElse(null);
    }
    @Override
    public CommentDto create(CommentCreateForm form,long postId){
        var optional = postRepository.findById(postId);
        if(optional.isEmpty())
            return null;
        var post = optional.get();
        var comment = CommentMapper.map(form);
        comment.setPost(post);
        var saveComment = commentRepository.save(comment);
        return CommentMapper.map(saveComment);
    }
    @Override
    public CommentDto update(CommentUpdateForm form, Long id){
        var optinal = commentRepository.findById(id);
        if(optinal.isEmpty()){
            return null;
        }
        var comment = optinal.get();
        CommentMapper.map(form,comment);
        var saveComment = commentRepository.save(comment);
        return CommentMapper.map(saveComment);
    }
    @Override
    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAllByPostId(Long postId) {
        commentRepository.deleteAllByPostId(postId);
    }
}
