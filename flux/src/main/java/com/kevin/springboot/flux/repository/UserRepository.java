package com.kevin.springboot.flux.repository;

import com.kevin.springboot.flux.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;

/**
 * {@link com.kevin.springboot.flux.domain.User} 用户的仓储
 *
 * @Auther: liangxuekai
 * @Date: 18/9/27 14:39
 * @Description:
 */
@Repository
public class UserRepository {
    private final DataSource dataSource;

    @Autowired
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean save(User user) {
        System.out.println("save user" + user);
        return true;
    }

    public Collection<User> findAll() {
        return Collections.emptyList();
    }
}
