package com.xuanthanh.blog_app.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentUpdateForm {
    // @Positive: so nguyen
    // @Negative : so am


    @NotBlank(message = "Ten khong duoc de trong")
    @Length(max=50,message = "Ten co toi da 50 ki tu")
    private String name;

    @NotBlank(message = "Email khong duoc de trong")
    @Length(max=70,message = "Email co toi da 75 ki tu")
    @Email(message = "Email khong dung dinh dang")
    private String email;

    @NotBlank(message = "Body khong duoc de trong")
    @Length(max=100,message = "Body co toi da 100 ki tu")
    private String body;
}
