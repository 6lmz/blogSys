package cdu.lmz.service;

import cdu.lmz.model.Log;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
public interface LogService {
    List<Log> findAll();
    List<Log> findByUserId(int userId);
    boolean insert(Log log);
}
