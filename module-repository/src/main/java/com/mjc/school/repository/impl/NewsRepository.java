package com.mjc.school.repository.impl;

import com.mjc.school.repository.AuthorModel;
import com.mjc.school.repository.NewsModel;

import java.time.LocalDateTime;
import java.util.*;

public class NewsRepository implements NewsRepositoryInterface {

    private Long newsIdCounter;
    private final List<NewsModel> newsDataSource;
    private final List<AuthorModel> authorDataSource;

    public NewsRepository() {
        authorDataSource = new LinkedList<>();
        Scanner authorsScanner = new Scanner(this.getClass().getResourceAsStream("author.txt"));
        for (long i = 1; authorsScanner.hasNext(); i++) {
            String authorName = authorsScanner.nextLine();
            authorDataSource.add(new AuthorModel(i, authorName));
        }

        List<String> contentList = new ArrayList<>();
        Scanner contentScanner = new Scanner(this.getClass().getResourceAsStream("content.txt"));
        while (contentScanner.hasNext()) {
            contentList.add(contentScanner.nextLine());
        }
        newsDataSource = new LinkedList<>();
        Scanner newsScanner = new Scanner(this.getClass().getResourceAsStream("news.txt"));
        long i = 1;
        for (; newsScanner.hasNext(); i++) {
            String newsTitle = newsScanner.nextLine();

            String newsContentNumberLine = newsScanner.nextLine();
            int newsContentNumber = Integer.parseInt(newsContentNumberLine);
            String newsContent = contentList.get(newsContentNumber);

            String newsCreateLine = newsScanner.nextLine();
            LocalDateTime newsCreateDate = LocalDateTime.parse(newsCreateLine);

            String newsLastUpdateLine = newsScanner.nextLine();
            LocalDateTime newsLastUpdateDate = LocalDateTime.parse(newsLastUpdateLine);

            String newsAuthorNumberLine = newsScanner.nextLine();
            int newsAuthorNumber = Integer.parseInt(newsAuthorNumberLine);
            AuthorModel newsAuthor = authorDataSource.get(newsAuthorNumber);

            newsDataSource.add(new NewsModel(i, newsTitle, newsContent, newsCreateDate, newsLastUpdateDate, newsAuthor));
        }
        newsIdCounter = i;
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        String title = newsModel.getTitle();
        String content = newsModel.getContent();
        LocalDateTime createDate = newsModel.getCreateDate();
        LocalDateTime lastUpdateDate = newsModel.getLastUpdateDate();
        Long authorId = newsModel.getId();
        AuthorModel author = authorDataSource.stream()
                .filter(a -> Objects.equals(a.getId(), authorId))
                .findFirst()
                .orElse(null);
        NewsModel newsToBeAdded = new NewsModel(newsIdCounter++, title, content, createDate, lastUpdateDate, author);
        newsDataSource.add(newsToBeAdded);
        return newsToBeAdded;
    }

    @Override
    public List<NewsModel> readAll() {
        return newsDataSource;
    }

    @Override
    public NewsModel readById(Long newsId) {
        return newsDataSource.stream()
                .filter(n -> Objects.equals(n.getId(), newsId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        Long id = newsModel.getId();
        String title = newsModel.getTitle();
        String content = newsModel.getContent();
        LocalDateTime createDate = newsModel.getCreateDate();
        LocalDateTime lastUpdateDate = newsModel.getLastUpdateDate();
        Long authorId = newsModel.getId();
        AuthorModel author = authorDataSource.stream()
                .filter(a -> Objects.equals(a.getId(), authorId))
                .findFirst()
                .orElse(null);
        NewsModel newsToBeUpdated = new NewsModel(id, title, content, createDate, lastUpdateDate, author);
        newsDataSource.replaceAll(n -> Objects.equals(n.getId(), id) ? newsToBeUpdated : n);
        return newsToBeUpdated;
    }

    @Override
    public Boolean delete(Long newsId) {
        return newsDataSource.removeIf(n -> Objects.equals(n.getId(), newsId));
    }
}
