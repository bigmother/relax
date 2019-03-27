package org.xzm.relax.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xzm.relax.model.entity.User;

public interface UserDao extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username=:account OR u.phone=:account")
    User findByAccount(@Param("account") String account);
}
