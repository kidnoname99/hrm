package com.lexuantung.hrm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
     @Id
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column
    private String cmnd;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String password;

    @ManyToMany
    @JoinTable(name = "permission"
            , joinColumns = @JoinColumn(name = "userID", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "roleID", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<Role>();

    @OneToMany(mappedBy = "employee")
    private List<Detail> details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
