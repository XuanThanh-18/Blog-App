package com.xuanthanh.blog_app.service;

import com.xuanthanh.blog_app.dto.UserDto;
import com.xuanthanh.blog_app.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}
