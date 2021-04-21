package com.library.core.serviceImpl;


import com.library.core.mapper.dao.AdminDao;
import com.library.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public String getAdminName (String name) {
        return adminDao.getName(name);
    }
}
