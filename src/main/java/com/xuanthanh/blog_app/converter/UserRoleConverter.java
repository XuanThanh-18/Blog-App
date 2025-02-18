package com.xuanthanh.blog_app.converter;

import com.xuanthanh.blog_app.entity.Post;
import com.xuanthanh.blog_app.entity.User;
import jakarta.persistence.AttributeConverter;

public class UserRoleConverter implements AttributeConverter<User.Role,Character> {
    @Override
    public Character convertToDatabaseColumn(User.Role attribute) {
        return attribute.toString().charAt(0);
    }

    @Override
    public User.Role convertToEntityAttribute(Character code) {
        if(code == 'A') return User.Role.ADMIN;
        if(code == 'E') return User.Role.EMPLOYEE;
        return User.Role.MANAGER;
    }
}
