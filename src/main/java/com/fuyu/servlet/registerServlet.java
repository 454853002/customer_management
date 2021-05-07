package com.fuyu.servlet;

import com.fuyu.entity.Login;
import com.fuyu.service.Impl.LoginServiceImpl;
import com.fuyu.service.Impl.RegisterServiceImpl;
import com.fuyu.service.Interface.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.trim().equals("")||password.trim().equals("")){
            response.sendRedirect(request.getContextPath()+"/register.jsp");
            return;
        }

        Login login = new Login();

        login.setUsername(username);
        login.setPassword(password);

        RegisterService registerService = new RegisterServiceImpl();

        boolean register = registerService.register(login);
        System.out.println("register"+register);
        if (register){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else {
            request.setAttribute("message", "注册失败<br>");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
