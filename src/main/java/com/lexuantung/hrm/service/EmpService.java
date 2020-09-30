package com.lexuantung.hrm.service;


import com.lexuantung.hrm.entity.Employee;
import com.lexuantung.hrm.model.request.user.EmpRequest;
import com.lexuantung.hrm.model.request.user.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {
    void insert(EmpRequest empRequest);
    void update(EmpRequest empRequest);
    void delete(Long id);
    Employee findEmpByPhone(LoginRequest loginRequest);

    List<Employee> findAll();
}
