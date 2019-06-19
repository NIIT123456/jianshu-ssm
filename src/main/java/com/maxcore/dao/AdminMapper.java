package com.maxcore.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface AdminMapper {
    /**
     *据账号和密码查询管理员
     *
     */
    AdminMapper getByAccPass(@Param("account")String account, @Param("password")String password) throws Exception;

    /**
     * 据账号查询管理员
     * @param account
     * @return
     */
    AdminMapper getAdminByAccount(String account);

    /**
     * 注册
     */
    int insertAdmin(AdminMapper adminMapper)throws Exception;

//    更新管理员信息
    int updateAdmin(AdminMapper adminMapper);
}
