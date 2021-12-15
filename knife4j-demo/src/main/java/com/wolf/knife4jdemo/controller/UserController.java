package com.wolf.knife4jdemo.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.wolf.knife4jdemo.domain.User;
import com.wolf.knife4jdemo.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-12-15 10:15:10
 * @Description
 */
@ApiSupport(order = 100)//Knife4j增强之分组排序
@Api(tags = "用户模块")
@RestController
@RequestMapping("user")
public class UserController {

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


    /**
     * 接口排序 + 处理json格式数据
     *
     * @param user
     * @return
     */
    @ApiOperationSupport(order = 10) // Knife4j增强功能之接口排序: 递增
    @ApiOperation(value = "添加用户信息")
    @PutMapping("/add")
    public R addUser(@RequestBody User user) {
        if (user == null) {
            return R.fail("用户信息不能为null", null);
        }
        if (user.getId() != null) {
            return R.fail("用户Id不能传入", null);
        }
        System.out.println("添加用户成功 {} " + user);
        return R.success("添加用户成功", user);
    }


    /**
     * 多参数 + 接口排序(默认为0)
     *
     * @return
     */
    @ApiOperation(value = "用户登录检查")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户姓名", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String", required = true)
    })
    @PostMapping("/login/{username}/{password}")
    public R login(@PathVariable String username, @PathVariable String password) {
        if (username == null || password == null) {
            System.out.println("用户名 {} 不能为空，用户密码 {} 不能为空");
            return R.fail("用户名 {} 不能为空，用户密码 {} 不能为空", null);
        }
        //检查用户是否存在
        Boolean flag = true;
        if (flag) {
            User user = new User();
            user.setId(10)
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

            return R.success("用户登录成功", user);
        }
        return R.fail("用户登录失败", null);

    }


}
