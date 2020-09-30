package com.lexuantung.hrm.service.impl;


import com.lexuantung.hrm.entity.Employee;
import com.lexuantung.hrm.entity.Role;
import com.lexuantung.hrm.model.request.user.EmpRequest;
import com.lexuantung.hrm.model.request.user.LoginRequest;
import com.lexuantung.hrm.repository.EmployeeRepository;
import com.lexuantung.hrm.repository.RoleRepository;
import com.lexuantung.hrm.service.EmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class EmployeeServiceImpl implements EmpService {
    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void insert(EmpRequest empRequest) {
        Employee employee = new Employee();
        Set<Role> roles = new HashSet<>();
        for (Long id: empRequest.getIds()){
            Role role = roleRepository.getOne(id);
            roles.add(role);
        }
        employee.setRoles(roles);
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmpRequest empRequest) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(empRequest,employee);
        Set<Role> roles = new HashSet<>();
        for (Long id: empRequest.getIds()){
            Role role = roleRepository.getOne(id);
            roles.add(role);
        }
        employee.setRoles(roles);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {

        Employee employee = employeeRepository.getOne(id);
        for (Role role: employee.getRoles()){
            role.getEmps().remove(employee);
        }
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findEmpByPhone(LoginRequest loginRequest) {
        Employee employee = employeeRepository.findEmployeeByPhoneAndPassword(loginRequest.getPhone(), loginRequest.getPassword());

        if (employee == null){
            return null;
        }
        return employee;


    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
