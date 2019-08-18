package com.ahscuml.Junit;

/**
 * @author ahscuml
 * @date 2019/3/2
 * @time 17:14
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTest1 {
    @Test
    public void testAdd() {
        //test data
        int num = 98;
        String temp = null;
        String str = "Junit is working fine";

        //check for equality
        assertEquals("Junit is working fine", str);

        //check for false condition
        assertFalse(num > 6);

        //check for not null value
        assertNotNull(str);
    }
}
