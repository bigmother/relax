package org.xzm.relax.model.dto.condition;

import lombok.Data;

/**
 * 分页
 * @author xuzhemin
 * 2019/3/20
 */
@Data
class PageBean {
    protected Integer pageNumber = 1;
    protected Integer pageSize = 20;
}
