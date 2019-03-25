package org.xzm.relax.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xzm.relax.model.entity.User;

public interface UserDao extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);
}
