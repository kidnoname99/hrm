package com.lexuantung.hrm.entity;



import javax.persistence.*;
import java.time.LocalTime;



@Embeddable
@Table(name = "detail")
public class Detail {
    @Column
    private LocalTime startTime;
    @Column
    private LocalTime endTime;
    @Column
    private String kiemSat;

    @ManyToOne
    @JoinColumn(name="idCN")
    private CongNhat congNhat;

    @ManyToOne
    @JoinColumn(name="idJob", referencedColumnName="id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="projId", referencedColumnName="id")
    private DuAn project;
    @ManyToOne
    @JoinColumn(name="empId", referencedColumnName="id")
    private Employee employee;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getKiemSat() {
        return kiemSat;
    }

    public void setKiemSat(String kiemSat) {
        this.kiemSat = kiemSat;
    }

    public CongNhat getCongNhat() {
        return congNhat;
    }

    public void setCongNhat(CongNhat congNhat) {
        this.congNhat = congNhat;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public DuAn getProject() {
        return project;
    }

    public void setProject(DuAn project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
