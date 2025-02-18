package com.xuanthanh.blog_app.form;

import com.xuanthanh.blog_app.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Parent;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank(message = "Ten khong duoc de trong")
    @Length(max=50)
    private String name;

    @NotBlank
    @Length(max=50)
    private String username;

    @NotBlank
    @Length(max=50)
    @Email
    private String email;

    @NotBlank
    @Length(max=32,min=8)
    private String password;

    @NotBlank
    @Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER")
    private String role;
}
