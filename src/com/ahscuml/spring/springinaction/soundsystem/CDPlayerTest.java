package com.ahscuml.spring.springinaction.soundsystem;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ahscuml
 * @date 2019/5/11
 * @time 0:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc  cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }
}
