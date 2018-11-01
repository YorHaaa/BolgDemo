package Servlet;

import Entity.User;
import Dao.UserDao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZYP
 * @date 2018/10/31 0:14
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        UserDaoImpl userDao = new UserDaoImpl();
        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        User user = userDao.getUserInfobyname(name);
        if (userDao.isexit(name)) {
            if (user.getUsername().equals(name) && !user.getPwd().equals(pwd)) {
                out.print("密码错误");
                response.setHeader("Refresh", "3;URL=/login.jsp");
            } else {
                request.getSession().setAttribute("username", name);
                request.getSession().setAttribute("pwd", pwd);
                request.getSession().setAttribute("info", user.getInfo());
                request.getSession().setAttribute("email", user.getQq());
                request.getSession().setAttribute("phone", user.getPhone());
                request.getSession().setAttribute("id", user.getId());
                out.print("<script>" + "alert('登陆成功了~~');"+ "</script>");
                response.setHeader("Refresh", "1;URL=/index.jsp");
            }
        } else {
            out.print("<script>" + "alert('你还没注册，快去注册吧~');"+ "</script>");
            response.setHeader("Refresh", "1;URL=/index.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
