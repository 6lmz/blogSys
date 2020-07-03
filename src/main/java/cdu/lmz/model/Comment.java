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
public class Comment implements Serializable {
    private Integer id;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date contentTime;
    private Integer user_id;
    private Integer blog_id;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentTime=" + contentTime +
                ", user_id=" + user_id +
                ", blog_id=" + blog_id +
                ", user=" + user +
                '}';
    }
}
