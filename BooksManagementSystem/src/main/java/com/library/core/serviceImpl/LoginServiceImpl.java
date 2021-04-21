package com.library.core.serviceImpl;


import com.library.core.mapper.dao.AdminDao;
import com.library.core.mapper.dao.ReaderCardDao;
import com.library.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ReaderCardDao readerCardDao;

    public boolean hasMatchReader (long readerId, String password) {
        return readerCardDao.getIdMatchCount(readerId, password) > 0;
    }

    public String getAdminUsername (long adminId) {
        return adminDao.getUsername(adminId);
    }


}
