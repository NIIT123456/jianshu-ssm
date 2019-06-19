package com.maxcore.service;

import com.maxcore.dao.LikeMapper;
import com.maxcore.entity.Collect;
import com.maxcore.entity.Like;
import com.maxcore.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoServiceImplTest {
    @Autowired
    private UserDaoService userDaoService;

    @Test
    public void insertUser() throws Exception {
        User user = new User();
//        user.setAccount(1702343247);
        user.setName("覃韦娜");
        user.setPassword("191214");
        user.setEmail("1511540879@foxmail.com");
        user.setProfile_photo("1.jpg");
        userDaoService.insertUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        userDaoService.deleteUser(1);
    }

    @Test
    public void updateUser() throws Exception {
        User user = userDaoService.getUserById(1);
//        user.setAccount(1702343244);
        user.setName("覃韦娜");
        user.setPassword("111111");
        user.setEmail("1511540879@foxmail.com");
        user.setProfile_photo("1.jpg");
//        System.out.println(userDaoService.updateUser(user));
    }

    @Test
    public void getUserById() throws Exception {
        System.out.println(userDaoService.getUserById(2));
    }

    @Test
    public void listUsers() throws Exception {
//        List<User>userList=userDaoService.listUsers();
//        userList.forEach(user -> System.out.println(user));
    }

    @Autowired
    private LikeMapper likeMapper;

    @Test
    public void isLikeOrCollectTest() {
        Integer userId = 1;
        Integer articleId = 1;
        Integer articleId2 = 2;

        Like isLike = likeMapper.isHasLike(userId, articleId);
        Collect collect = likeMapper.isHasCollect(userId, articleId);
        Collect collect2 = likeMapper.isHasCollect(userId, articleId2);
        System.out.println(collect.toString());
//        System.out.println(collect2.toString());
//        System.out.println(isLike.toString());
    }

    @Test
    public void getLikeById() {
        Like like = likeMapper.selectByPrimaryKey(1);
        System.out.println(like);
    }

}