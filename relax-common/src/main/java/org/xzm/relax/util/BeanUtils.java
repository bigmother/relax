package org.xzm.relax.util;

public class BeanUtils {

    private BeanUtils(){}

    public static <T> T copyProperties(Object source,Class<T> type){
        T target = null;
        try {
            target = type.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source,target);
        } catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }
}
