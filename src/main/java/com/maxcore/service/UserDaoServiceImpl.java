package com.maxcore.service;

import com.github.pagehelper.Page;
import com.maxcore.dao.UserDao;
import com.maxcore.entity.User;
import com.maxcore.entity.dto.UserDTO;
import com.maxcore.util.MsgConst;
import com.maxcore.util.PageUtil;
import com.maxcore.util.ResponseResult;
import com.maxcore.util.StatusConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

/**
 * User服务
 *
 * @author Maxcore
 */
@Service
public class UserDaoServiceImpl implements UserDaoService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult signIn(String account, String password) throws Exception {
        if (account == null || password == null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.IS_NULL);
        User user = userDao.getUserByAccount(account);
        //手机号不存在
        if (user == null) {
            return ResponseResult.error(StatusConst.PASSWORD_ERROR, MsgConst.USER_MOBILE_NO_FOUND);
        }
        //密码不正确
        if (!password.equals(user.getPassword())) {
            return ResponseResult.error(StatusConst.PASSWORD_ERROR, MsgConst.PASSWORD_ERROR);
        }
        return ResponseResult.success(user);
    }

    @Override
    public ResponseResult register(String account, String password, String name, String email) throws Exception {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setProfile_photo("http://ppeto2k90.bkt.clouddn.com/avatar/default.png");
        userDao.insertUser(user);
        return ResponseResult.success(user);
    }

    @Override
    public int insertUser(User user) throws Exception {
        return userDao.insertUser(user);
    }


    @Override
    public ResponseResult deleteUser(Integer id) throws Exception {
        if (id == null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.ID_NULL);
        userDao.deleteUser(id);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult updateUser(Integer id, String userName, String password, String email,
                                     String profilePhoto) throws Exception {
        if (id == null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.ID_NULL);
        User user = new User();
        user.setEmail(email);
        user.setName(userName);
        user.setPassword(password);
        user.setProfile_photo(profilePhoto);
        user.setId(id);
        System.out.println(user.toString());
        userDao.updateUser(user);
        return ResponseResult.success(user);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userDao.getUserById(id);
    }

    @Override
    public ResponseResult getUserList(Integer currentPage, Integer pageSize) throws Exception {
        List<User> users = userDao.getUserList();
        List<User> list = PageUtil.pageDemo(currentPage, pageSize, users);
        return ResponseResult.succ(list, users.size());
    }

    @Override
    public ResponseResult getUsersByNameList(String name, Integer currentPage, Integer pageSize) throws Exception {
        //模糊查询
        List<User> users = userDao.getUsersByNameList(name);
        List<User> list = PageUtil.pageDemo(currentPage, pageSize, users);
        return ResponseResult.succ(list, users.size());
    }

}
