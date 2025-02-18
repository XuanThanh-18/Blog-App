package com.xuanthanh.blog_app.generator;

import com.xuanthanh.blog_app.entity.User;
import com.xuanthanh.blog_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class UserIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        var user = (User) object;
        var role = user.getRole();
        // hibernate language co hai loai:
        // ?1,?2,?3,...
        // name parameter dung dau :
        var hql = "SELECT COUNT(*) FROM User WHERE role = :role";
        long count = session
                .createSelectionQuery(hql,Long.class)
                .setParameter("role",role)
                .uniqueResult();
        return String.format("%c-%d",role.toString().charAt(0),count+1);
    }
}
