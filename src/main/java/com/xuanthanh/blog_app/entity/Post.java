package com.xuanthanh.blog_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="post")
@Getter
@Setter
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title",length = 50, nullable = false)
    private String title;

    @Column(name = "description",length = 100, nullable = false)
    private String description;

    @Column(name = "content",length = 150, nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //@OneToOne(mappedBy = "post") // bang post cung co thong tin cua cac comment
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
