package com.library.core.mapper.dao;

import com.library.core.mapper.AdminMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminDao implements AdminMapper {

    private final static String NAMESPACE = "com.library.core.mapper.dao.AdminDao.";

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int getMatchCount(final long admin_id, final String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("admin_id", admin_id);
        paramMap.put("password", password);
        return sqlSessionTemplate.selectOne(NAMESPACE + "getMatchCount", paramMap);
    }

    public int resetPassword(final long admin_id, final String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("admin_id", admin_id);
        paramMap.put("password", password);
        return sqlSessionTemplate.update(NAMESPACE + "resetPassword", paramMap);
    }

    public String getPassword(final long admin_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getPassword", admin_id);
    }

    public String getUsername(final long admin_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getUsername", admin_id);
    }

    public String getName (final String name) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getName", name);
    }
}
