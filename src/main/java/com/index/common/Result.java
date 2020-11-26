package com.index.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author index
 * @date 2020/9/28
 **/
@Data
@AllArgsConstructor
public class Result {
    private static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = 1;

    private State state;
    private Object data;

    public Result(int code, String msg, Object data){
        this.state = new State(code, msg);
        this.data = data;
    }

    public static Result success(){
        return new Result(SUCCESS_CODE, "ok", null);
    }

    public static Result success(Object data){
        return new Result(SUCCESS_CODE, "ok", data);
    }

    public static Result success(String msg, Object data){
        return new Result(SUCCESS_CODE, msg, data);
    }

    public static Result fail(String msg){
        return new Result(FAIL_CODE, msg, null);
    }

    public static Result fail(int code, String msg){
        return new Result(code, msg, null);
    }

}
