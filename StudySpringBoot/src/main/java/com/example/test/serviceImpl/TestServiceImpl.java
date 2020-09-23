package com.example.test.serviceImpl;

import com.example.test.bean.TestBean;
import com.example.test.mapper.TestMapper;
import com.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired(required=false)
    TestMapper testMapper;

    public String getName (int id) {
        System.out.println(testMapper.selectName(id).getCode());
        return testMapper.selectName(id).getName();
    }
}
