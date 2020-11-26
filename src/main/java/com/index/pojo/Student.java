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
public class Student{
    private String no;
    private String name;
    private int age;
    private int year;

    //班级，聚合关系
//    private int myclassId;
    private Myclass myclass;

    private String idcard;
    private String location;
    private Date brithday;
    private String phone;
    private String mail;
}
