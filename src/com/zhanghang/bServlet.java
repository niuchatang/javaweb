package com.zhanghang;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "bServlet",urlPatterns = {"/bpage"})
public class bServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");

        response.setContentType("text/html;charset=utf-8");
        // 获得Session
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(1000);
        //设置Sesion属性
        session.setAttribute("username",username);
//        //设置Cookie
//        Cookie cookie = new Cookie("username", username);
//        //设置Cookie超时时间
//        cookie.setMaxAge(1000);//cookie时间
//        //添加Cookie,要保证在out.close();之前执行
//        response.addCookie(cookie);
        StringBuffer sbr = new StringBuffer();
        sbr.append("<!DOCTYPE html>");
        sbr.append("<html>");
        sbr.append("<head>");
        sbr.append("    <meta charset=\"UTF-8\">");
        sbr.append("	<title>B页面</title>");
        sbr.append("</head>");
        sbr.append("<body>");
        sbr.append("<form action=\"cpage\" method=\"post\">");
        sbr.append("	用户名：").append(username).append("<br>");
//        sbr.append("	<a href=\"cpage?page=B&username=").append(username).append("\">跳转到C页面</a>");//URL重写保持Web状态
        sbr.append("	<input type=\"submit\" value=\"跳转到C页面\">");
//        sbr.append("	<input type=\"hidden\" name=\"username\" value=\"").append(username).append("\">");//隐藏域保持Web状态
//       sbr.append("	<input type=\"hidden\" name=\"page\" value=\"A\">");//隐藏域保持Web状态
        sbr.append("</form>");
        sbr.append("</body>");
        sbr.append("</html>");
        PrintWriter out = response.getWriter();
        out.print(sbr.toString());
        out.close();

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
