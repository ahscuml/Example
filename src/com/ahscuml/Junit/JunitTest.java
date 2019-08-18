package com.ahscuml.Junit;
/**
 * @author ahscuml
 * @date 2019/3/2
 * @time 17:00
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JunitTest {

    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        message = "New World";
        assertEquals(message, messageUtil.printMessage());
    }
}
