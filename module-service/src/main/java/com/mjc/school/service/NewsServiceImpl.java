package com.mjc.school.service;

import com.mjc.school.repository.AuthorModel;
import com.mjc.school.repository.NewsModel;
import com.mjc.school.repository.NewsRepository;

import java.time.LocalDateTime;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;

    public NewsServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public NewsDto createNews(NewsDto newsDto) {
        newsDto.setCreateDate(LocalDateTime.now());
        newsDto.setLastUpdateDate(LocalDateTime.now());
        return newsModelToNewsDto(repository.createNews(newsDtoToNewsModel(newsDto)));
    }

    @Override
    public List<NewsDto> getAllNews() {
        return repository.getAllNews()
                .stream()
                .map(this::newsModelToNewsDto)
                .toList();
    }

    @Override
    public NewsDto getNewsById(Long newsId) {
        return newsModelToNewsDto(repository.getNewsById(newsId));
    }

    @Override
    public NewsDto updateNews(NewsDto newsDto) {
        newsDto.setLastUpdateDate(LocalDateTime.now());
        return newsModelToNewsDto(repository.updateNews(newsDtoToNewsModel(newsDto)));
    }

    @Override
    public boolean deleteNews(Long newsId) {
        return repository.deleteNews(newsId);
    }

    private NewsModel newsDtoToNewsModel(NewsDto newsDto) {
        Long id = newsDto.getId();
        String title = newsDto.getTitle();
        String content = newsDto.getContent();
        LocalDateTime createDate = newsDto.getCreateDate();
        LocalDateTime lastUpdateDate = newsDto.getLastUpdateDate();
        Long authorId = newsDto.getAuthorId();
        String authorName = newsDto.getAuthorName();
        return new NewsModel(id, title, content, createDate, lastUpdateDate, new AuthorModel(authorId, authorName));
    }

    private NewsDto newsModelToNewsDto(NewsModel newsModel) {
        Long id = newsModel.getId();
        String title = newsModel.getTitle();
        String content = newsModel.getContent();
        LocalDateTime createDate = newsModel.getCreateDate();
        LocalDateTime lastUpdateDate = newsModel.getLastUpdateDate();
        Long authorId = newsModel.getAuthorModel().getId();
        String authorName = newsModel.getAuthorModel().getName();
        return new NewsDto(id, title, content, createDate, lastUpdateDate, authorId, authorName);
    }
}
