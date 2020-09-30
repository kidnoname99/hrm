package com.lexuantung.hrm.repository;


import com.lexuantung.hrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByPhoneAndPassword(String phone, String password);

}
