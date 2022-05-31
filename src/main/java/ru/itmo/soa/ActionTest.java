package ru.itmo.soa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SOA-Lab1
 * @author: Siyuan
 * @create: 2022-05-28 15:24
 **/

@WebServlet(name = "ActionTest", urlPatterns = "/ActionTest")
public class ActionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("do Get");
        resp.getWriter().write("<h1>Hello World</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("do Post");
        resp.getWriter().write("<h1>Hello World</h1>");
    }
}
