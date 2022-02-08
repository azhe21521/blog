package com.mszlu.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    //代表是否成功
    private boolean success;

    //代表我们的编码
    private int code;

    //代表的是消息
    private String msg;

    //代表的是数据
    private Object data;

    public static Result success(Object date){
        return new Result(true,200,"success",date);
    }

    public static Result Fail(int code ,String msg){
        return new Result(false,code,msg,null);
    }
}
