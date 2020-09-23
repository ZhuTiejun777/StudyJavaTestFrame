package com.example.test;

import com.example.test.bean.UserBean;
import com.example.test.service.TestService;
import com.example.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    //UserService userService;
    TestService testService;

    /*@Test
    public void contextLoads() {
        UserBean userBean = userService.loginIn("test","testpd");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }

    @Test
    public void addUser () {
        UserBean userBean = new UserBean();
        userBean.setId(8);
        userBean.setName("name");
        userBean.setPassword("password");
        userBean.setRole("test");
        int result = userService.addUser(userBean);
        assert result == 1;
    }*/

    @Test
    public void getName () {
        String name = testService.getName(1);
        System.out.println(name);
        assert name.equals("图片新闻");
    }

}
