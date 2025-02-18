package com.xuanthanh.blog_app.specification;

import com.xuanthanh.blog_app.entity.Comment;
import com.xuanthanh.blog_app.form.CommentFilterFrom;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class CommentSpecification {
    public static Specification<Comment> buildSpec(CommentFilterFrom form){
        return form == null ? null : new Specification<Comment>() {
            @Override
            public Predicate toPredicate(
                    Root<Comment> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder) {
                var predicates = new ArrayList<Predicate>();

                var search = form.getSearch();
                if(search!= null){
                    //... where name like "% ... % " or email like "%...%"
                    var hasNameLike = builder.like(
                            root.get("name"),
                            "%" + search + "%"
                    );
                    var hasEmailLike = builder.like(
                            root.get("email"),
                            "%" + search + "%"
                    );
                    var predicate = builder.or(hasEmailLike,hasNameLike);
                    predicates.add(predicate);
                }
                var postId = form.getPostId();
                if(postId != null){
                    //... where post_id = ?
                    var predicare = builder.equal(
                            root.get("post").get("id"),
                            postId
                    );
                    predicates.add(predicare);
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
