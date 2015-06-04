package bsuir.model.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private int experience;
    private int hoursWork;
    private int hourlyRate;
    private int award;
    private int orderId;
    private int roleId;

    public Worker() {
    }

    public Worker(int id, String surname, String name, String patronymic, int age, int experience,
            int hoursWork, int hourlyRate, int award, int orderId, int roleId) {
        super();
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.experience = experience;
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
        this.award = award;
        this.orderId = orderId;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(int hoursWork) {
        this.hoursWork = hoursWork;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}
