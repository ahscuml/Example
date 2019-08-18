package com.ahscuml.spring.springinaction.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author ahscuml
 * @date 2019/5/11
 * @time 0:40
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "DaoXiang";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
