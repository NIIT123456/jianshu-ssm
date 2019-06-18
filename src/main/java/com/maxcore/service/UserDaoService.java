package com.maxcore.service;

import com.github.pagehelper.Page;
import com.maxcore.entity.User;
import com.maxcore.entity.dto.UserDTO;
import com.maxcore.util.ResponseResult;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

public interface UserDaoService {
    /**
     * 根据accountc查询用户信息
     * */
    /**
     * 登录方法
     * */
    ResponseResult signIn(String userName, String password) throws Exception;
    /**
     * 注册
     */
    ResponseResult register(String account,String password,String name,String email) throws Exception;

    int insertUser(User user)throws Exception;

    ResponseResult deleteUser(Integer id)throws Exception;
    ResponseResult updateUser(Integer id,String userName,String password,String email,
                   String profilePhoto)throws Exception;
    User getUserById(int id)throws Exception;
   ResponseResult getUserList(Integer currentPage,Integer pageSize)throws Exception;
    ResponseResult getUsersByNameList(String name,Integer currentPage,
                                       Integer pageSize)throws Exception;
}
