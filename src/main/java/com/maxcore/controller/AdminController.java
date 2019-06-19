package com.maxcore.controller;

import com.maxcore.entity.Admin;
import com.maxcore.entity.User;
import com.maxcore.entity.dto.AdminDTO;
import com.maxcore.entity.dto.UserDTO;
import com.maxcore.service.AdminDaoService;
import com.maxcore.service.AdminDaoServiceImpl;
import com.maxcore.util.MsgConst;
import com.maxcore.util.ResponseResult;
import com.maxcore.util.StatusConst;
import com.maxcore.vo.Menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器
 *
 * @author Maxcore
 * @date 2019/06/14
 */
@RestController
@Api(tags = "2.管理员模块")
@RequestMapping("/admins")
public class AdminController {
//    @Autowired
//    private AdminDaoServiceImpl adminDaoServiceImpl;
//
//    @ApiOperation(value = "管理员登录")
//    @PostMapping(value = "/signIn")
//    public ResponseResult signIn(String account, String password) throws Exception {
//        return adminDaoServiceImpl.signIn(account, password);
//    }
//
//    @ApiOperation(value = "添加一个管理员")
//    @PostMapping(value = "/register")
//    public ResponseResult register(String account, String name, String password) throws Exception {
//        return adminDaoServiceImpl.addAdmin(account, name, password);
//    }
//
//    @ApiOperation(value = "修改管理员信息")
//    @PostMapping(value = "updateAdminMsg")
//    public ResponseResult updateAdminMsg(Integer id, String name, String password) {
//        return adminDaoServiceImpl.changeAdminMsg(id, name, password);
//    }

}
