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
public class Admin {
    private int id;
    private String name;
    private Date birthday;
    private String nativePlace;  //籍贯
    private String phone;
    private String email;
}
