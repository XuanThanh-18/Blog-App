package com.xuanthanh.blog_app.form;

import com.xuanthanh.blog_app.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm {
    @NotBlank(message = "Tieu de khong duoc de trong")
    @Length(max=50,message = "Tieu de khong vuot qua 50 ki tu")
    private String title;

    @NotBlank(message = "Mo ta khong duoc de trong")
    @Length(max=100,message = "Mo ta khong vuot qua 50 ki tu")
    private String description;

    @NotBlank(message = "Noi dung khong duoc de trong")
    @Length(max=150,message = "Noi dung khong vuot qua 50 ki tu")
    private String content;
}
