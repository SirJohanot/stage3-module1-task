package com.mjc.school.service;

import com.mjc.school.repository.impl.NewsRepository;

import java.time.LocalDateTime;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;

    public NewsServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public NewsDto createNews(NewsDto newsDto) {
        newsDto.setCreateDate(LocalDateTime.now().toString());
        newsDto.setLastUpdateDate(LocalDateTime.now().toString());
        return NewsMapper.INSTANCE.newsModelToNewsDto(repository.create(NewsMapper.INSTANCE.newsDtoToNewsModel(newsDto)));
    }

    @Override
    public List<NewsDto> getAllNews() {
        return repository.readAll()
                .stream()
                .map(NewsMapper.INSTANCE::newsModelToNewsDto)
                .toList();
    }

    @Override
    public NewsDto getNewsById(Long newsId) {
        return NewsMapper.INSTANCE.newsModelToNewsDto(repository.readById(newsId));
    }

    @Override
    public NewsDto updateNews(NewsDto newsDto) {
        newsDto.setLastUpdateDate(LocalDateTime.now().toString());
        return NewsMapper.INSTANCE.newsModelToNewsDto(repository.update(NewsMapper.INSTANCE.newsDtoToNewsModel(newsDto)));
    }

    @Override
    public boolean deleteNews(Long newsId) {
        return repository.delete(newsId);
    }

}
