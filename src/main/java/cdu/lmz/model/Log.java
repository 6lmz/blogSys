package cdu.lmz.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
public class Log implements Serializable {
    private Integer id;
    private String operate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operateTime;
    private Integer user_id;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", operate='" + operate + '\'' +
                ", operateTime=" + operateTime +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }
}
