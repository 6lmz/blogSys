package cdu.lmz.service.impl;

import cdu.lmz.dao.LogDao;
import cdu.lmz.model.Log;
import cdu.lmz.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    LogDao logDao;

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }

    @Override
    public List<Log> findByUserId(int userId) {
        return logDao.findByUserId(userId);
    }

    @Override
    public boolean insert(Log log) {
        return logDao.insert(log) == 1?true:false;
    }
}
