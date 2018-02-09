package com.springboot.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 11:05
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@WebServlet(urlPatterns = "/test2")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置返回类型为json
        resp.setContentType("application/text");
        //设置返回的字符集
        resp.setCharacterEncoding("utf-8");
        //输出对象
        PrintWriter writer =resp.getWriter();
        //输出error消息
        writer.write("执行testServlet内的doGet()方法执行成功");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置返回类型为json
        resp.setContentType("application/text");
        //设置返回的字符集
        resp.setCharacterEncoding("utf-8");
        //输出对象
        PrintWriter writer =resp.getWriter();
        //输出error消息
        writer.write("执行testServlet内的doPost()方法执行成功");
        writer.close();
    }
}
