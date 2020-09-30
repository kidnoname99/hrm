package com.lexuantung.hrm.service;


import com.lexuantung.hrm.model.request.user.EmpRequest;
import org.springframework.stereotype.Service;

//@Service
public interface UserServices {
    void save(EmpRequest empRequest);
}
