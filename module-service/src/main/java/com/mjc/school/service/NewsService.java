package com.mjc.school.service;

import java.util.List;

public interface NewsService {

    NewsDto createNews(NewsDto newsDto);

    List<NewsDto> getAllNews();

    NewsDto getNewsById(Long newsId);

    NewsDto updateNews(NewsDto newsDto);

    boolean deleteNews(Long newsId);
}
