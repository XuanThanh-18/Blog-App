package com.xuanthanh.blog_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@Getter
@Setter
public class Comment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false,length = 50)
    private String name;

    @Column(name="email",nullable = false,length = 75)
    private String email;

    @Column(name="body",nullable = false,length = 100)
    private String body;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //@OneToOne
    @ManyToOne
    @JoinColumn(
            name="post_id",
            referencedColumnName = "id",
            //unique = true, cau hinh 1-1
            nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;


}
