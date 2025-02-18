package com.xuanthanh.blog_app.repository;

import com.xuanthanh.blog_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameOrEmail(String username,String email);
}
