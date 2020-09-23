package com.example.test.mapper;

import com.example.test.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;

public interface TestMapper {

    TestBean selectName (int id);

}
