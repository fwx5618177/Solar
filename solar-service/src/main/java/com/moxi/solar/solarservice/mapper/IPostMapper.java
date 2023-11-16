package com.moxi.solar.solarservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.moxi.solar.solarservice.model.SolarPost;

@Mapper
public interface IPostMapper {
    SolarPost selectPostById(Long id);

    @Select("SELECT * FROM solar_post WHERE title = #{title}")
    SolarPost selectPostByTitle(String title);
}
