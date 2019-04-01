package org.xzm.relax.util;

import org.springframework.security.core.context.SecurityContextHolder;
/**
 * 认证权限相关工具
 *
 * @author Administrator
 */
public class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * 获取当前用户id
     *
     * @return 用户id
     */
    public static String getUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
