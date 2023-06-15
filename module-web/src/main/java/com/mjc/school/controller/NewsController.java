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
        return null;
    }

    public List<NewsDto> getAllNews() {
        return null;
    }

    public NewsDto getNewsById(Long newsId) {
        return null;
    }

    public NewsDto updateNews(NewsDto newsDto) {
        return null;
    }

    public boolean deleteNews(Long newsId) {
        return false;
    }
}
