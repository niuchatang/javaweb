package com.zhanghang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DServlet", urlPatterns = {"/delsession"})
public class DServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.removeAttribute("username");
//        设置Cookie
//        Cookie cookie = new Cookie("username", null);
//        //设置Cookie超时时间
//        cookie.setMaxAge(0);//cookie时间
//        //添加Cookie,要保证在out.close();之前执行
//        response.addCookie(cookie);



        response.setContentType("text/html;charset=utf-8");
        StringBuffer sbr = new StringBuffer();
        sbr.append("<!DOCTYPE html>");
        sbr.append("<html>");
        sbr.append("<head>");
        sbr.append("    <meta charset=\"UTF-8\">");
        sbr.append("	<title>删除Session页面</title>");
        sbr.append("</head>");
        sbr.append("<body>");
        sbr.append("	Session已经删除");
//        sbr.append("	上一个页面：").append(page).append("<br>");
//        sbr.append("<a href=\"<delcookie?username=\"").append(pname).append(">删除Cookie</a>");
        sbr.append("</body>");
        sbr.append("</html>");
        PrintWriter out = response.getWriter();
        out.print(sbr.toString());
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
