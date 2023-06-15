package com.mjc.school.repository;

import java.util.List;

public interface NewsRepository {

    NewsModel createNews(NewsModel newsModel);

    List<NewsModel> getAllNews();

    NewsModel getNewsById(Long newsId);

    NewsModel updateNews(NewsModel newsModel);

    boolean deleteNews(Long newsId);

}
