package com.library.core.controller;


import com.library.core.serviceImpl.AdminServiceImpl;
import com.library.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginController {

    private final Logger logger = Logger.getLogger (LoginController.class);

    /*@Autowired
    private LoginService LoginService;*/

    @Autowired
    private AdminServiceImpl adminService;

    /*@RequestMapping(value = {"/", "/login.html"})
    public String toLogin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.html";
    }*/

    @RequestMapping(value = "/getName", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> getAdmin () {
        logger.info("请求成功！");
        Result<String> result = new Result<String>();
        result.setMessage("test");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("admin", adminService.getAdminName("admin"));
        result.setData(jsonObject.toString());
        return result;
    }

}
