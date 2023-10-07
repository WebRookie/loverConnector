package com.rookie.loverconnector.record.service.impl;

import cn.hutool.core.lang.UUID;
import com.rookie.loverconnector.record.dao.RecordDao;
import com.rookie.loverconnector.record.service.RecordService;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordReq;
import com.rookie.loverconnector.user.dao.UserDao;
import com.rookie.loverconnector.user.vo.UserVO;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WebRookie
 * @date 2023/8/1 20:40
 **/
@Service
@Slf4j
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordDao recordDao;

    @Resource
    private UserDao userDao;

    @Override
    public List<RecordVO> findUserRecordList(RecordReq recordReq) {
        System.out.println(recordReq);
        return recordDao.getRecordList(recordReq);
    }

    @Override
    public int createRecord(RecordVO recordVo) {
        UserVO user = userDao.getUserByUserId(recordVo.getUserId());
        if(user == null) {
            log.info("用户不存在");
            return 0;
        }
        recordDao.createRecord(recordVo);
        return 1;
    }
}
