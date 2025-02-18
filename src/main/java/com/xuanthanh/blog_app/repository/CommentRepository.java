package com.xuanthanh.blog_app.repository;

import com.xuanthanh.blog_app.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {
    //1. method name
    // Prefix: findBy, countBy, deleteBy, existsBy

    // select * from comment where email = ?;
    List<Comment> findByEmail(String email);
    List<Comment> findByIdGreaterThanEqualAndIdLessThanEqual(Long minId,Long maxId);
    Page<Comment> findByPostId(Long postId, Pageable pageable);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);

    //2. @Query
    // HQL
    //---> truyen tham do theo thu tu (Index)
    @Query("DELETE FROM Comment WHERE post.id = ?1")
    @Modifying // neu lam thay doi du lieu trong database
    @Transactional // neu thanh cong thi thanh cong, neu bi loi thi se tu dong rollback
    void deleteAllByPostId(Long postId);

    // ---> truyen tham so theo ten bien ket hop @Param (name parameter)

//    @Query("DELETE FROM Comment WHERE post.id = :postId")
//    @Modifying // neu lam thay doi du lieu trong database
//    @Transactional // neu thanh cong thi thanh cong, neu bi loi thi se tu dong rollback
//    void deleteAllByPostId(@Param("postId") Long postId);

    // SQL
    //---> viet theo cau lenh mysql
//    @Query(value = "DELETE FROM comment WHERE post_id = :postId",nativeQuery = true)
//    @Modifying // neu lam thay doi du lieu trong database
//    @Transactional // neu thanh cong thi thanh cong, neu bi loi thi se tu dong rollback
//    void deleteAllByPostId(@Param("postId") Long postId);
}
