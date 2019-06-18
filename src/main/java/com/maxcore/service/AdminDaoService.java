package com.maxcore.service;

import com.maxcore.entity.Admin;
import com.maxcore.entity.dto.AdminDTO;
import com.maxcore.util.ResponseResult;

public interface AdminDaoService {
    /**
     *管理员登录
     *
     */
    ResponseResult signIn(String userName, String password) throws Exception;

    /**
     * 注册
     */
    ResponseResult addAdmin(String account,String name,String password) throws Exception;

}
