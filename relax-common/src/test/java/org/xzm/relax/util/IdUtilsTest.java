package org.xzm.relax.util;

import org.junit.Test;

/**
 * @author xuzhemin
 * 2019/3/25
 */
public class IdUtilsTest {

    @Test
    public void nextIdTest(){
        for (int i=0;i<100;i++){
            System.out.println(IdUtils.id());
        }
    }
}
