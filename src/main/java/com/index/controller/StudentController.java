package com.index.controller;

import com.index.common.Result;
import com.index.dto.CourseListDto;
import com.index.pojo.Course;
import com.index.pojo.Student;
import com.index.pojo.Takes;
import com.index.pojo.User;
import com.index.service.CourseService;
import com.index.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author index
 * @date 2020/11/12
 **/
@RequestMapping("/xjgl/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/getSelectedCourse")
    public Result getSelectedCourses(HttpSession session){
        User user = (User)session.getAttribute("user");

        List<Course> selectedCourse = studentService.getSelectedCourse(user.getNo());
        List<CourseListDto> courseListDtos = new ArrayList<>(selectedCourse.size());

        for (Course course : selectedCourse) {
            CourseListDto courseListDto = new CourseListDto();
            BeanUtils.copyProperties(course, courseListDto);
            courseListDtos.add(courseListDto);
        }
        return Result.success(courseListDtos);
    }

    //选课
    @GetMapping("/addCourse")
    public Result addCourse(@RequestParam("id") int id, HttpSession session){
        User user = (User)session.getAttribute("user");
        studentService.addTakes(user.getNo(), id);
        return Result.success();
    }

    //查询学籍信息
    @GetMapping("/getStudentInfo")
    public Result getStudentInfo(HttpSession session){
        User user = (User)session.getAttribute("user");
        Student student = studentService.getStudentInfo(user.getNo());
        return Result.success(student);
    }

    //查询成绩
    @GetMapping("/getGrade")
    public Result getGrade(){
        return Result.success();
    }

}
