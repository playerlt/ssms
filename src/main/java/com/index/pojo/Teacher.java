package com.index.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author index
 * @date 2020/11/11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher{
    private String id;
    private String name;
    private String dept_name;
    private String phone;
    private String mail;
}
