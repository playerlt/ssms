package com.index.controller;

import com.index.common.Result;
import com.index.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author index
 * @date 2020/11/12
 **/
@RestController
public class AdminController {
    @Autowired
    CourseService courseService;

    /**
     *
     * @param no 学号
     * @return
     */
    @GetMapping("/getGrade")
    public Result getGrade(String no){
        return Result.success();
    }

    /**
     *
     * @param no 学号
     * @return
     */
    @PostMapping("/changeGrade")
    public Result changeGrade(String no){
        return Result.success();
    }

    /**
     *
     * @param id 课程id
     * @return
     */
    @GetMapping("/getCourseInfo")
    public Result getCourseInfo(int id){
        return Result.success();
    }

    /**
     *
     * @param no 学号
     * @return
     */
    @GetMapping("/getStudentCourses")
    public Result getStudentCourses(String no){
        return  Result.success();
    }

    //添加和修改课程接口复用
    @PostMapping(value = {"/addCourse", "/modifyCOurse"})
    public Result addCourse(){
        return Result.success();
    }

    @PostMapping("/deleteCourse")
    public Result deleteCourse(){
        return Result.success("删除成功");
    }

}
