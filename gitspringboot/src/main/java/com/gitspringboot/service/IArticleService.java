package com.gitspringboot.service;
import java.util.List;

import com.gitspringboot.model.*;
public interface IArticleService {
	List<Article> getAllArticles();
    Article getArticleById(int articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
}
