package com.ahscuml.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author ahscuml
 * @date 2019/5/9
 * @time 21:49
 */
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("hello world");
            response.getWriter().println(new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
