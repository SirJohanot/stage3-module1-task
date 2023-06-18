package com.mjc.school.repository.impl;

import com.mjc.school.repository.NewsModel;

import java.util.List;

public interface NewsRepositoryInterface {

    NewsModel create(NewsModel newsModel);

    List<NewsModel> readAll();

    NewsModel readById(Long newsId);

    NewsModel update(NewsModel newsModel);

    Boolean delete(Long newsId);

}
