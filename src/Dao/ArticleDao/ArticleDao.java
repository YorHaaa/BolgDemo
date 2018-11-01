package Dao.ArticleDao;

import Entity.Article;

import java.util.List;


public interface ArticleDao {
    void addArticle(Article article);
    List<Article> findall();
    Article findbytitle(String title);
    int updatearticle(Article article);
    void delAriticle(int id);
}
