package com.index.service;

import com.index.pojo.Course;
import com.index.pojo.Student;
import com.index.pojo.Takes;

import java.util.List;

/**
 * @author index
 * @date 2020/11/12
 **/
public interface StudentService {
    List<Course> getSelectedCourse(String no);

    void addTakes(String no, int id);

    Student getStudentInfo(String no);
}
