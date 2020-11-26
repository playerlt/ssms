package com.index.service.impl;

import com.index.dao.StudentMapper;
import com.index.dao.TakesMapper;
import com.index.dao.UserMapper;
import com.index.pojo.Course;
import com.index.pojo.Student;
import com.index.pojo.Takes;
import com.index.pojo.User;
import com.index.service.StudentService;
import com.index.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author index
 * @date 2020/11/12
 **/
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Course> getSelectedCourse(String no){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TakesMapper mapper = sqlSession.getMapper(TakesMapper.class);
        List<Course> selectedCourse = mapper.getSelectedCourse(no);
//        System.out.println(user);
        sqlSession.close();
        return selectedCourse;
    }

    @Override
    public void addTakes(String no, int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TakesMapper mapper = sqlSession.getMapper(TakesMapper.class);
        mapper.addCourse(no, id);
//        System.out.println(user);
        sqlSession.close();
    }

    @Override
    public Student getStudentInfo(String no) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.getStudentInfo(no);
        sqlSession.close();
        return student;
    }
}
