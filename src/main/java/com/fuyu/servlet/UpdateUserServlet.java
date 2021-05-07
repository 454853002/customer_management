package com.fuyu.servlet;

import com.fuyu.entity.User;
import com.fuyu.service.Impl.UserServiceImpl;
import com.fuyu.service.Interface.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdateUserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("ID"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birth = request.getParameter("birth");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        /**
         * 判断是否为空
         */
        if (id == 0||name.trim().equals("")||sex.trim().equals("")||phone.trim().equals("")
                ||birth.trim().equals("")||phone.trim().equals("")||note.trim().equals("")){
            request.getRequestDispatcher("/update.jsp").forward(request, response);
            return;
        }
        if (sex.trim().equals("男")||sex.trim().equals("man")||sex.trim().equals("m")){
            sex = "m";
        }else if (sex.trim().equals("女")||sex.trim().equals("f")||sex.trim().equals("female")){
            sex = "f";
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        user.setBirth(birth);
        user.setPhone(phone);
        user.setNote(note);

        boolean b = userService.updateUser(user);
        if (b){
            /**
             * 修改成功
             */
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
                   String  ID = String.valueOf(users.get(i).getId());
                    idsmap.put(String.valueOf(i), ID);
                }
                request.setAttribute("ids", idsmap);
                //name数据和
                Map<String, String> namesmap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    name = String.valueOf(users.get(i).getName());
                    namesmap.put(String.valueOf(i), name);
                }
                request.setAttribute("names", namesmap);

                //sex数据和
                Map<String, String> sexmap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    sex = String.valueOf(users.get(i).getSex());
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
                    birth = String.valueOf(users.get(i).getBirth());
                    birthmap.put(String.valueOf(i), birth);
                }
                request.setAttribute("births", birthmap);
                //phone
                Map<String, String> phonemap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    phone = String.valueOf(users.get(i).getPhone());
                    phonemap.put(String.valueOf(i), phone);
                }
                request.setAttribute("phones", phonemap);
                //phone
                Map<String, String> notemap = new HashMap<>();
                for (int i = 0; i < users.size(); i++) {
                    note = String.valueOf(users.get(i).getNote());
                    notemap.put(String.valueOf(i), note);
                }
                request.setAttribute("notes", notemap);

            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }else {
            //request.setAttribute("addInfo","修改失败");
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }



    }


}

