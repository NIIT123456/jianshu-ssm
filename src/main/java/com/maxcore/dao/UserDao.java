package com.maxcore.dao;

import com.github.pagehelper.Page;
import com.maxcore.entity.User;
import com.maxcore.entity.dto.UserDTO;
import com.maxcore.util.ResponseResult;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

/**
 * User服务接口
 */
public interface UserDao {
User getUserByAccount(String account);
    /**
     * 增加用户
     * @param user
     * @return
     */
    int insertUser(User user)throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    void deleteUser(Integer id)throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user)throws Exception;

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(int id)throws Exception;

    /**
     * 获取用户列表
     * @return
     */
    List<User>getUserList()throws Exception;

    /**
     * 根据用户名进行分页模糊查询
     * @param name
     * @param
     * @return
     */
    List<User> getUsersByNameList(String name)throws Exception;



}
