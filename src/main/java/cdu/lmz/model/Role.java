package cdu.lmz.model;

import java.io.Serializable;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
public class Role implements Serializable {
    private Integer id;
    private String power;
    private Integer user_id;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", power='" + power + '\'' +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }
}
