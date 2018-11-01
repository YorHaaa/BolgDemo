package Servlet;

import Entity.Article;
import Dao.ArticleDao.ArticleDaoImpl;
import Dao.ArticleTypeDao.ArticletypeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author ZYP
 * @date 2018/10/31 0:14
 */
@WebServlet("/write")
public class WriteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        ArticletypeDaoImpl articletypeDao = new ArticletypeDaoImpl();
        Article article = new Article();
        String type = request.getParameter("article_type");
        int articletypeid = articletypeDao.getArticletypeid(type);
        if (articletypeid != 0) {
            article.setArticle_type(articletypeid);
        } else {
            articletypeDao.addArticletype(type);
            int id = articletypeDao.getArticletypeid(type);
            article.setArticle_type(id);
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int user_id = (int) request.getSession().getAttribute("id");
        article.setTitle(title);
        article.setUser_id(user_id);
        article.setPub_date(new Date());
        article.setContent(content);

        articleDao.addArticle(article);
        response.setHeader("Refresh", "1;URL=/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
