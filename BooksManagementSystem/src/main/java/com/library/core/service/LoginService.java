package com.library.core.service;

public interface LoginService {

    boolean hasMatchReader (long readerId, String password);

    String getAdminUsername (long adminId);
}
