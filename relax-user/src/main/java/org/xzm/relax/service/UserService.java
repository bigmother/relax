package org.xzm.relax.service;

import org.springframework.data.domain.Page;
import org.xzm.relax.model.dto.UserDTO;
import org.xzm.relax.model.dto.condition.UserCondition;
import org.xzm.relax.model.dto.create.UserCreate;
import org.xzm.relax.model.dto.update.UserUpdate;

public interface UserService {

    /**
     * 创建用户
     * @param userCreate 创建用户类
     * @return 用户
     */
    UserDTO create(UserCreate userCreate);

    /**
     * 更新用户
     * @param userUpdate 更新用户类
     * @return 用户
     */
    UserDTO update(UserUpdate userUpdate);

    /**
     * 分页查询用户列表
     * @param userCondition 查询条件
     * @return 用户分页数据
     */
    Page<UserDTO> page(UserCondition userCondition);

    /**
     * 删除用户
     * @param id 用户id
     */
    void delete(Long id);

}
