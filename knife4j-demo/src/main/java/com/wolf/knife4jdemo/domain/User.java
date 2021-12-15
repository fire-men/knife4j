package com.wolf.knife4jdemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-12-15 10:11:19
 * @Description
 */
@ApiModel(description = "用户实体类")
@Data
@Accessors(chain = true)
public class User {
    @ApiModelProperty(value = "用户Id")
    private Integer id;
    @ApiModelProperty(value = "用户姓名")
    private String username;
    @ApiModelProperty(value = "用户昵称")
    private String nickname;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户地址")
    private String address;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "当前用户是否被删除 0:未删除 1:已删除")
    private Integer isDeleted;
    @ApiModelProperty(value = "当前登录用户状态 0:正常 1:失效 2:被锁定")
    private Integer status;
    @ApiModelProperty(value = "评论")
    private String comment;
    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    //解决前端传入时间格式问题
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updateBy;
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
}
