package com.xuanthanh.blog_app.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentFilterFrom {
    private String search;
    private Long postId;
}
