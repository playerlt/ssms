package com.index.dao;

import com.index.pojo.Course;
import com.index.pojo.Takes;

import java.util.List;

/**
 * @author index
 * @date 2020/11/12
 **/
public interface TakesMapper {
    void addCourse(String no, int id);

    List<Course> getSelectedCourse(String no);
}
