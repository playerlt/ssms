package com.index.util;

import java.util.Random;

/**
 * @author index
 * @date 2020/9/6
 **/
public class VeriCode {
    Random random = new Random();
    public String sixNumCode(){
        double code = random.nextDouble() * Math.pow(10, 6);
        return String.format("%06.0f", code);
    }
}
