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
public class Teaches{
//    private int tid;
//    private int cid;
    private Teacher teacher;
    private Course course;
}
