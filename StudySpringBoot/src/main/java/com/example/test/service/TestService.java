package com.example.test.service;

import com.example.test.bean.TestBean;
import com.example.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface TestService {

    String getName (int id);
}
