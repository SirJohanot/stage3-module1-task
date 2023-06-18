package com.mjc.school.controller;

import com.mjc.school.service.NewsDto;
import com.mjc.school.service.NewsService;

import java.util.List;

public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    public NewsDto createNews(NewsDto newsDto) {
        return newsService.createNews(newsDto);
    }

    public List<NewsDto> getAllNews() {
        return newsService.getAllNews();
    }

    public NewsDto getNewsById(Long newsId) {
        return newsService.getNewsById(newsId);
    }

    public NewsDto updateNews(NewsDto newsDto) {
        return newsService.updateNews(newsDto);
    }

    public boolean deleteNews(Long newsId) {
        return newsService.deleteNews(newsId);
    }
}
