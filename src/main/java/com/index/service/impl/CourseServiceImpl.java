package com.index.service.impl;

import com.index.dao.CourseMapper;
import com.index.dao.TakesMapper;
import com.index.pojo.Course;
import com.index.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author index
 * @date 2020/11/12
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    TakesMapper takesMapper;

}
