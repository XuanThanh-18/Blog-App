package com.xuanthanh.blog_app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CommentIdExistsValidator.class}
)
@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommentIdExists {
    String message() default "Binh luan khong ton tai";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
