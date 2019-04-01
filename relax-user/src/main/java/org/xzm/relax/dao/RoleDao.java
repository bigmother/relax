package org.xzm.relax.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xzm.relax.model.entity.Role;

/**
 * @author xuzhemin
 * 2019/4/1
 */
public interface RoleDao extends JpaRepository<Role,Long> {
}
