package Servlet;

import Dao.ArticleDao.ArticleDaoImpl;
import Dao.ArticleTypeDao.ArticletypeDao;
import Dao.ArticleTypeDao.ArticletypeDaoImpl;
import Entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZYP
 * @date 2018/10/31 10:13
 */

@WebServlet("/delete")
public class DeleteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ArticleDaoImpl articleDao = new ArticleDaoImpl();

        int articleId = Integer.parseInt(request.getParameter("id"));
        articleDao.delAriticle(articleId);
        out.println("<script>" + "alert('删除页面成功~');"+ "</script>");
        response.setHeader("Refresh", "1;URL=/archive.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
