package com.lexuantung.hrm.service;

import com.lexuantung.hrm.entity.Role;

import java.util.List;

public interface RoleService {
    Role findOne(long id);
    List<Role> findAll();
}
