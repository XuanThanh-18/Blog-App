package com.xuanthanh.blog_app.entity;

import com.xuanthanh.blog_app.converter.UserRoleConverter;
import com.xuanthanh.blog_app.generator.UserIdGenerator;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="user")
@Getter
@Setter

public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity: = Autoincrement in database : t đong tang

    // cau hinh kieu senquence
//    c1:
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) // SEQUENCE : tao mot bang seq in database de quan ly id
//    c2:
//    @SequenceGenerator(
//            name="user_id_generator", // ten cua generrator, su dung trong anotation ben duoi
//            sequenceName = "user_id_sequence", // ten bang tu sinh ra quan ly id
//            allocationSize = 1, // them bao nhieu doi tuong thi se tang kich thuoc cua allocationsize
//            initialValue = 10 // gia tri khoi tao cho bang quan ly id (khong phai gia tri id)
//    )
//    @GeneratedValue(generator = "user_id_generator")

    // cau hinh theo UUID (Universally unique identifier)
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @JdbcType(value = CharJdbcType.class) // luu trong database duoi dang char/ varchar
//    private UUID id; // luu trong database duoi dang nhi phan

    // cau hinh Custom
//    @GenericGenerator(
//            name="user_id_generator", // ten cua generator
//            type= UserIdGenerator.class // kieu xay dung
//    )
//    @GeneratedValue(generator = "user_id_generator")
    private Long id;

    @Column(name="name",length = 50,nullable = false)
    private String name;

    @Column(name="username",length = 50,unique = true,nullable = false)
    private String username;

    @Column(name="email",length = 50,unique = true,nullable = false)
    private String email;

    @Column(name="password",length = 100,nullable = false)
    private String password;

    @Column(name="role",nullable = false)
    // cach 1: luu theo thu tu EnumType.ORDINAL
    //@Enumerated(value = EnumType.ORDINAL)
    // cach 2: luu theo ten cua enum
    @Enumerated(value = EnumType.STRING)
    // cach3: Converter
    //@Convert(converter = UserRoleConverter.class)
    private Role role;

    @Column(name = "created_at" , nullable = false , updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="update_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum Role{
        ADMIN,EMPLOYEE,MANAGER

    }
}
