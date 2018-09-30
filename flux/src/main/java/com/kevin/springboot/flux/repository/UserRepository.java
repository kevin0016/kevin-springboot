package com.kevin.springboot.flux.repository;

import com.kevin.springboot.flux.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final DataSource masterDataSource;
    private final DataSource salveDataSource;


    public UserRepository(DataSource dataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("salveDataSource")DataSource salveDataSource) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.salveDataSource = salveDataSource;
    }

    public boolean save(User user) {
        System.out.printf("[Thread:%s] [save user:%s]\n" ,Thread.currentThread().getName(),user);
        return true;
    }

    public Collection<User> findAll() {
        return Collections.emptyList();
    }
}
