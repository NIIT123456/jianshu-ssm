package com.maxcore.controller;

import com.maxcore.entity.User;
import com.maxcore.entity.dto.UserDTO;
import com.maxcore.service.UserDaoService;
import com.maxcore.service.UserDaoServiceImpl;
import com.maxcore.util.MsgConst;
import com.maxcore.util.ResponseResult;
import com.maxcore.util.StatusConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

/**
 * 用户控制器
 *
 * @author Maxcore
 * @date 2019/06/16
 */
@RestController
@Api(tags = "1.用户模块")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDaoServiceImpl userDaoServiceImpl;

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/signIn")
    public ResponseResult signIn(String account, String password) throws Exception {
        return userDaoServiceImpl.signIn(account, password);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public ResponseResult register(String account, String password, String userName,
                                   String email) throws Exception {
        return userDaoServiceImpl.register(account, password, userName, email);
    }

    @ApiOperation(value = "所有用户列表")
    @GetMapping(value = "getAllUserList")
    public ResponseResult getAllUserList(Integer currentPage, Integer pageSize) throws Exception {
        return userDaoServiceImpl.getUserList(currentPage, pageSize);
    }

    @ApiOperation("据用户名搜索用户")
    @GetMapping(value = "searchByUserNameList")
    public ResponseResult searchByUserNameList(String keyword, Integer currentPage,
                                               Integer pageSize) throws Exception {
        return userDaoServiceImpl.getUsersByNameList(keyword, currentPage, pageSize);
    }

    @ApiOperation(value = "修改用户信息")
    @PostMapping(value = "updateUserMsg")
    public ResponseResult updateUserMsg(Integer id, String userName, String password, String email,
                                        String profilePhoto) throws Exception {
        return userDaoServiceImpl.updateUser(id, userName, password, email, profilePhoto);
    }

    @ApiOperation(value = "删除一个用户")
    @GetMapping(value = "delUser")
    public ResponseResult delUser(Integer id) throws Exception {
        return userDaoServiceImpl.deleteUser(id);
    }

}
