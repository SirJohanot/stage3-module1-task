package com.mjc.school.service;

import com.mjc.school.repository.NewsRepository;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;

    public NewsServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public NewsDto createNews(NewsDto newsDto) {
        return null;
    }

    @Override
    public List<NewsDto> getAllNews() {
        return null;
    }

    @Override
    public NewsDto getNewsById(Long newsId) {
        return null;
    }

    @Override
    public NewsDto updateNews(NewsDto newsDto) {
        return null;
    }

    @Override
    public boolean deleteNews(Long newsId) {
        return false;
    }
}
