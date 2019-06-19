package com.maxcore.service;

import com.maxcore.dao.AdminMapper;
import com.maxcore.entity.Admin;
import com.maxcore.util.MsgConst;
import com.maxcore.util.ResponseResult;
import com.maxcore.util.StatusConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDaoServiceImpl  {
//    @Autowired
//    private AdminMapper adminMapper;
//
//    @Override
//    public ResponseResult signIn(String account, String password) throws Exception {
//        if (account == null || password == null)
//            return ResponseResult.error(StatusConst.ERROR, MsgConst.IS_NULL);
//        AdminMapper adminMapper = this.adminMapper.getAdminByAccount(account);
//        if (adminMapper == null)
//            return ResponseResult.error(StatusConst.ERROR, MsgConst.USER_MOBILE_NO_FOUND);
//        AdminMapper adminMapper2 = this.adminMapper.getByAccPass(account, password);
//        if (adminMapper2 == null)
//            return ResponseResult.error(StatusConst.ERROR, "账号或者密码不正确");
//        return ResponseResult.success();
//    }
//
//    @Override
//    public ResponseResult addAdmin(String account, String name, String password) throws Exception {
//        if (account == null || name == null || password == null)
//            return ResponseResult.error(StatusConst.ERROR, "请输入注册信息");
//        if (this.adminMapper.getAdminByAccount(account) != null)
//            return ResponseResult.error(StatusConst.ERROR, "账号已被注册");
//        Admin admin = new Admin();
//        admin.setPassword(password);
//        admin.setAccount(account);
//        admin.setName(name);
//        this.adminMapper.insertAdmin(adminMapper);
//        return ResponseResult.success(adminMapper);
//    }
//
//    public ResponseResult changeAdminMsg(Integer id, String name, String password) {
//        if (id == null)
//            return ResponseResult.error(StatusConst.ERROR, MsgConst.ID_NULL);
//        Admin admin = new Admin();
//        admin.setName(name);
//        admin.setPassword(password);
//        admin.setId(id);
//        adminMapper.updateAdmin(adminMapper);
//        return ResponseResult.success(adminMapper);
//    }

}
