package Servlet;

import Dao.UserDao.UserDaoImpl;
import Entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZYP
 * @date 2018/10/31 0:14
 */
@WebServlet("/update")
public class UpdateUserSevlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws HTTPException,IOException {
        HttpSession session = request.getSession();
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        int id = Integer.parseInt(session.getAttribute("id").toString());
        user.setId(id);
        user.setEmail(email);
        user.setPwd(pwd);
        user.setPhone(phone);
        user.setQq(qq);
        user.setUsername(name);
        if (userDao.updateuser(user) != 0) {
            out.print("<script>" + "alert('更新信息成功了~');"+ "</script>");
            response.setHeader("Refresh", "1;URL=/index.jsp");
        } else {
            out.print("<script>" + "alert('更新信息失败了=。=');"+ "</script>");
            response.setHeader("Refresh", "1;URL=/index.jsp");
        }
    }
}
