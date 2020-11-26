package com.index.controller;


import com.index.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author index
 * @date 2020/11/12
 **/
@RestController
public class TeacherController {
    @PostMapping
    public Result submitGrade(@RequestParam("id") int id,
                              @RequestParam("grade") float grade){
        return Result.success();
    }
}
