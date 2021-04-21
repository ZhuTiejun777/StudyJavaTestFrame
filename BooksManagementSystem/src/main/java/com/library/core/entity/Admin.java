package com.library.core.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin {

    private long admin_id;
    private String password;
    private String username;
}
