package com.maxcore.service;

import com.maxcore.dao.AdminDao;
import com.maxcore.entity.Admin;
import com.maxcore.entity.User;
import com.maxcore.entity.dto.AdminDTO;
import com.maxcore.util.MsgConst;
import com.maxcore.util.ResponseResult;
import com.maxcore.util.StatusConst;
import com.sun.deploy.util.UpdateCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDaoServiceImpl implements AdminDaoService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public ResponseResult signIn(String account, String password) throws Exception {
        if (account == null || password == null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.IS_NULL);
        Admin admin = adminDao.getAdminByAccount(account);
        if (admin == null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.USER_MOBILE_NO_FOUND);
        Admin admin2 = adminDao.getByAccPass(account, password);
        if (admin2 == null)
            return ResponseResult.error(StatusConst.ERROR, "账号或者密码不正确");
        return ResponseResult.success();
    }

    @Override
    public ResponseResult addAdmin(String account, String name, String password) throws Exception {
        if (account == null || name == null || password == null)
            return ResponseResult.error(StatusConst.ERROR, "请输入注册信息");
        if (adminDao.getAdminByAccount(account) != null)
            return ResponseResult.error(StatusConst.ERROR, "账号已被注册");
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setName(name);
        admin.setPassword(password);
        adminDao.insertAdmin(admin);
        return ResponseResult.success(admin);
    }

    public ResponseResult changeAdminMsg(Integer id, String name, String password) {
        if (id == null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.ID_NULL);
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setPassword(password);
        adminDao.updateAdmin(admin);
        return ResponseResult.success(admin);
    }

}
