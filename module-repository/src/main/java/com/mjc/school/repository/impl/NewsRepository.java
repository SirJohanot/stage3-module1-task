package com.mjc.school.repository.impl;

import com.mjc.school.repository.NewsModel;

import java.util.List;

public interface NewsRepository {

    NewsModel create(NewsModel newsModel);

    List<NewsModel> readAll();

    NewsModel readById(Long newsId);

    NewsModel update(NewsModel newsModel);

    boolean delete(Long newsId);

}
