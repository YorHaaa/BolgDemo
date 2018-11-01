package Dao.ArticleTypeDao;

import Entity.Article;
import Entity.Article_type;


public interface ArticletypeDao {
    int addArticletype(String type);
    int getArticletypeid(String name);
}
