package org.xzm.relax.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xzm.relax.model.entity.User;

public interface UserDao extends JpaRepository<User,Long> {
}
