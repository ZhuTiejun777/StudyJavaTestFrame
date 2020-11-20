package com.qa.attempt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//测试对象序列化，将对象转换为json数据格式
public class TestObjectMapper {

    //测试单个对象user转换为json数据格式
    @Test
    public void test01() throws JsonProcessingException {
        //1、创建对象user
        User user = new User("我是GF_浪夏一学 - 单个对象", 21, "男", "湖南");
        //2、writeValueAsString()方法，将一个user对象转成json字符串
        String userJson = new ObjectMapper().writeValueAsString(user);//将javabean转换为json数据格式
        /*JSONObject jsonObject = JSON.parseObject(userJson);
        System.out.println(jsonObject);*/
        System.out.println(userJson);
    }

    //将一个对象数组转换为json数据格式
    @Test
    public void test02() throws JsonProcessingException {
        //1、创建对象，加入集合中
        User user1 = new User("我是集合user1",21,"男","湖南");
        User user2 = new User("我是集合user2",20,"女","北京");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        //2、writeValueAsString()方法，将一个对象数组转换为json数据格式
        String userListJson = new ObjectMapper().writeValueAsString(userList);
        System.out.println(userListJson);
    }

    //将一个Map集合转成json字符串
    @Test
    public void test03() throws JsonProcessingException {
        //1:创建对象
        User user1 = new User("我是map集合的user1对象",21,"男","湖南");
        User user2 = new User("我是map集合的user2对象",20,"女","北京");
        //存入map
        Map<String,User> map  = new HashMap<String,User>();
        map.put("user1",user1);
        map.put("user2",user2);
        //2、writeValueAsString()方法，将一个Map集合转成json字符串
        String json= new ObjectMapper().writeValueAsString(map);
        System.out.println(json);
    }

/*    //将一个json数据转换为user对象
    @Test
    public void test04() throws IOException {
        //1:创建一个json对象
        String jsonData = "{\"name\":\"我是GF_浪夏一学\",\"age\":21,\"sex\":\"男\",\"address\":\"湖南\"}";
        //2、writeValueAsString()方法，将一个Map集合转成json字符串
        User user = new ObjectMapper().readValue(jsonData, User.class);
        System.out.println(user);//会输出user的toString()方法
    }

    //测试json数据转集合list
    @Test
    public void test05() throws IOException {
        String json="[{\"name\":\"我是GF_浪夏一学\",\"age\":21,\"sex\":\"男\",\"address\":\"湖南\"},{\"name\":\"java小皮孩\",\"age\":21,\"sex\":\"男\",\"address\":\"深圳\"}]";
        //
        ObjectMapper objectMapper = new ObjectMapper();
        //将json转成对象   参1 json数据  参2 new TypeReference<>(){}
        List<User> userList = new ObjectMapper().readValue(json, new TypeReference<List<User>>(){});
        System.out.println(userList);
    }*/

}
