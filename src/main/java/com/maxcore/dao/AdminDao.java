package com.maxcore.dao;

import com.maxcore.entity.Admin;
import com.maxcore.entity.User;
import com.maxcore.entity.dto.AdminDTO;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    /**
     *据账号和密码查询管理员
     *
     */
    Admin getByAccPass(@Param("account")String account,@Param("password")String password) throws Exception;

    /**
     * 据账号查询管理员
     * @param account
     * @return
     */
    Admin getAdminByAccount(String account);

    /**
     * 注册
     */
    int insertAdmin(Admin admin)throws Exception;

//    更新管理员信息
    int updateAdmin(Admin admin);
}
