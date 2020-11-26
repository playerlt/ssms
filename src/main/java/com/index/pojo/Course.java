package com.index.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author index
 * @date 2020/11/11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String name;  //课程名字
    private float credit;  //学分
    private int startWeek;  //开始周数
    private int endWeek;    //结束周数
    private int day;   //星期几
    private int startLesson;  //上课时间
    private int endLesson;    //下课时间
    private String classroom;  //教室
    private String deptName;  //系名
    private int studentNum;  //学生总数
}
