package com.zhanghang;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CServlet",urlPatterns = {"/cpage"})
public class CServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //取出Session
        HttpSession session = request.getSession();
        String pname = (String) session.getAttribute("username");
//        取出Cookie
//        String pname = null;
//        Cookie[] cookies = request.getCookies();//所有的Cookie
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {//cookies:null
//                if (cookie.getName().equals("username")) {
//                    pname = cookie.getValue();
//                    break;
//                }
//            }
//        }
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String page = request.getParameter("page");
        response.setContentType("text/html;charset=utf-8");
        StringBuffer sbr = new StringBuffer();
        sbr.append("<!DOCTYPE html>");
        sbr.append("<html>");
        sbr.append("<head>");
        sbr.append("    <meta charset=\"UTF-8\">");
        sbr.append("	<title>C页面</title>");
        sbr.append("</head>");
        sbr.append("<body>");
        sbr.append("	用户名：").append(pname).append("<br>");
//        sbr.append("	上一个页面：").append(page).append("<br>");
        sbr.append("<a href=\"delsession?username=\"").append(pname).append(">删除session</a>");
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
