package cdu.lmz.dao;

import cdu.lmz.model.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
@Repository
public interface LogDao {
//  系统日志
    List<Log> findAll();
    List<Log> findByUserId(int user_id);
    List<Log> findByPower(String power);
    int insert(Log log);
    int del(int id);
    int mod(Log log);

//    int insert(Log log);
//    List<Log> findAll();
//    List<Log> findByUserId(int user_id);

}
