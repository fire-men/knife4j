package com.wolf.knife4jdemo.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author zhangle
 * @CreateTime 2021-12-15 10:15:47
 * @Description
 */
@Data
public class R<T> {
    @ApiModelProperty(value = "响应状态码")
    private String code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "具体返回的对象")
    private T obj;

    private R(){}

    public static R success(String message,Object obj){
        R<Object> r = new R<>();
        r.setCode("0");
        r.setMessage(message);
        r.setObj(obj);
        return r;
    }

    public static R fail(String message,Object obj){
        R<Object> r = new R<>();
        r.setCode("1");
        r.setMessage(message);
        r.setObj(obj);
        return r;
    }
}
