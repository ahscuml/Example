package com.ahscuml.Junit;

/**
 * This class prints the given message on console.
 *
 * @author ahscuml
 * @date 2019/3/2
 * @time 17:05
 */
public class MessageUtil {

    private String message;

    /**
    * Constructor
    * @param message to be printed
    **/
    public MessageUtil(String message) {
        this.message = message;
    }

    /**
     * prints the message
     * */
    public String printMessage() {
        System.out.println(message);
        return message;
    }
}
