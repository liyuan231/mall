package com.liyuan;

import org.junit.Test;

public class NormalTest {

    @Test
    public void testFileName(){
        String name="1111.jpg";
        String format = name.substring(name.lastIndexOf("."));
        System.out.println(format);
    }

}
