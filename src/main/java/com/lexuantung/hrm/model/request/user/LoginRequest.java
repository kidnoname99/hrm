package com.lexuantung.hrm.model.request.user;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LoginRequest {
    private String phone;
    private String password;

    private Set<Long> ids = new HashSet<Long>();
}
