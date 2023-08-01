package com.rookie.loverconnector.record.service.impl;

import com.rookie.loverconnector.record.dao.RecordDao;
import com.rookie.loverconnector.record.service.RecordService;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordReq;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WebRookie
 * @date 2023/8/1 20:40
 **/
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordDao recordDao;

    @Override
    public List<RecordVO> findUserRecordList(RecordReq recordReq) {
        return recordDao.getRecordList(recordReq);
    }
}
