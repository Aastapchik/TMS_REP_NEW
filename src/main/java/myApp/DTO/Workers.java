package myApp.DTO;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Workers")
public class Workers {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_worker")
    private int employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String eMail;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "salary")
    private int salary;
    @Column(name = "commission_pct")
    private float commissionPCT;
    @Column(name = "department_id")
    private int departmentID;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public float getCommissionPCT() {
        return commissionPCT;
    }

    public void setCommissionPCT(float commissionPCT) {
        this.commissionPCT = commissionPCT;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}