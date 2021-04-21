package com.blog.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.blog.common.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog/api")
public class MainController {

    private final Logger logger = Logger.getLogger ( MainController.class );
    @RequestMapping ( value = "/check", method = RequestMethod.POST )
    @ResponseBody
    @CrossOrigin
    public Result<JSONObject> check () {
        logger.info("MainController run");
        Result<JSONObject> result = new Result<>();
        result.setMessage("SSM vue前后端框架搭建成功");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", "admin");
        jsonObject.put("password", "123456");
        result.setData(jsonObject);
        return result;
    }

}
