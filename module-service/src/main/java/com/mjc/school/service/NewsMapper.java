package com.mjc.school.service;

import com.mjc.school.repository.NewsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDto newsModelToNewsDto(NewsModel newsModel);

    NewsModel newsDtoToNewsModel(NewsDto newsDto);
}
