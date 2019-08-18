package com.ahscuml.example.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @author ahscuml
 * @date 2019/2/25
 * @time 19:23
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
