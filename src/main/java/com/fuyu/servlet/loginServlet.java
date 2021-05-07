package com.fuyu.servlet;


import com.fuyu.entity.Login;
import com.fuyu.entity.User;
import com.fuyu.service.Impl.LoginServiceImpl;
import com.fuyu.service.Impl.UserServiceImpl;
import com.fuyu.service.Interface.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        LoginService loginService = new LoginServiceImpl();

        Login current = loginService.login(login);
        //返回信息不为None,则登录成功
        if (current.getUsername().equals("None") ||  current.getPassword().equals("None") ){
            request.setAttribute("message", "账密错误，请重新登录<br>");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        else {
            //登录成功，加载数据
            UserServiceImpl userService = new UserServiceImpl();
            ArrayList<User> users = new ArrayList<>();
            try {
                ResultSet resultSet = userService.searchUsers();
                while (resultSet.next()) {
                    users.add(new User(resultSet.getInt("id"), resultSet.getString("name")
                            , resultSet.getString("sex"), resultSet.getString("birth"),
                            resultSet.getString("phone"), resultSet.getString("note")));
                }
                //id数据和
                Map<String, String> idsmap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    String id = String.valueOf(users.get(i).getId());
                    idsmap.put(String.valueOf(i), id);
                }
                request.setAttribute("ids", idsmap);
                //name数据和
                Map<String, String> namesmap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    String name = String.valueOf(users.get(i).getName());
                    namesmap.put(String.valueOf(i), name);
                }
                request.setAttribute("names", namesmap);

                //sex数据和
                Map<String, String> sexmap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    String sex = String.valueOf(users.get(i).getSex());
                    if (sex.trim().equals("m")){
                        sex ="男";
                    }else {
                        sex = "女";
                    }
                    sexmap.put(String.valueOf(i), sex);
                }
                request.setAttribute("sexes", sexmap);

                //birth
                Map<String, String> birthmap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    String birth = String.valueOf(users.get(i).getBirth());
                    birthmap.put(String.valueOf(i), birth);
                }
                request.setAttribute("births", birthmap);
                //phone
                Map<String, String> phonemap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    String phone = String.valueOf(users.get(i).getPhone());
                    phonemap.put(String.valueOf(i), phone);
                }
                request.setAttribute("phones", phonemap);
                //phone
                Map<String, String> notemap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    String note = String.valueOf(users.get(i).getNote());
                    notemap.put(String.valueOf(i), note);
                }
                request.setAttribute("notes", notemap);

            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/main.jsp").forward(request, response);
           // response.sendRedirect(request.getContextPath()+"/main.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
