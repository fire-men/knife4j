package com.wolf.knife4jdemo.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.wolf.knife4jdemo.domain.User;
import com.wolf.knife4jdemo.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-12-15 11:49:08
 * @Description
 */
@Api(tags = "角色模块")
@ApiSupport(order = 200)//Knife4j增强之分组排序
@RestController
@RequestMapping("role")
public class RoleController {

    /**
     * 单个参数
     *
     * @param userId
     * @return
     */
    @ApiOperationSupport(order = 8)
    @ApiOperation(value = "通过用户ID查询详情")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping(value = "/queryById/{userId}")
    public R<User> queryById(@PathVariable(required = true) Integer userId) {
        if (userId != null && !userId.equals(0)) {
            User user = new User();
            user.setId(userId)
                    .setUsername("李白")
                    .setNickname("诗仙")
                    .setAddress("河北")
                    .setEmail("libai@qq.com")
                    .setPassword("123456")
                    .setIsDeleted(0)
                    .setStatus(0)
                    .setComment("将进酒杯莫停")
                    .setCreateBy("李白")
                    .setCreateTime(new Date());

            return R.success("通过id查询用户详情", user);
        }
        return R.fail("用户id不能不空且不能为0", null);
    }
}
