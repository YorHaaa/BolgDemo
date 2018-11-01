package Servlet;

import Dao.ArticleDao.ArticleDao;
import Dao.ArticleDao.ArticleDaoImpl;
import Dao.ArticleTypeDao.ArticletypeDao;
import Dao.ArticleTypeDao.ArticletypeDaoImpl;
import Entity.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author ZYP
 * @date 2018/10/31 0:14
 */
@WebServlet("/updateArticle")
public class UpdateArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws HTTPException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //DAO层
        Article article = new Article();
        ArticletypeDaoImpl articletypeDao = new ArticletypeDaoImpl();
        ArticleDaoImpl articleDao = new ArticleDaoImpl();

        //获取参数
        int user_id = (int) request.getSession().getAttribute("id");
        String title = request.getParameter("title");
        String type = request.getParameter("article_type");
        String content = request.getParameter("content");
        int articleId = Integer.parseInt(session.getAttribute("articleId").toString());
        int articletypeid = articletypeDao.getArticletypeid(type);

        if ( articletypeid!= 0 ){
            article.setArticle_type(articletypeid);
        }
        else {
            articletypeDao.addArticletype(type);
            int id = articletypeDao.getArticletypeid(type);
            article.setArticle_type(id);
        }


        article.setId(articleId);
        article.setTitle(title);
        article.setUser_id(user_id);
        article.setPub_date(new Date());
        article.setContent(content);

        if (articleDao.updatearticle(article) != 0) {
            out.print("<script>" + "alert('更新文章成功了~');"+ "</script>");
            response.setHeader("Refresh", "1;URL=/archive.jsp");
        } else {
            out.print("<script>" + "alert('更新信息失败了=。=');"+ "</script>");
            response.setHeader("Refresh", "1;URL=/archive.jsp");
        }
    }
}
