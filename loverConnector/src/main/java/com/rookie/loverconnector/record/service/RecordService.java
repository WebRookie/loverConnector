package com.rookie.loverconnector.record.service;

import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordReq;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WebRookie
 * @date 2023/8/1 20:39
 **/
public interface RecordService {


    /**
     * 查询用户记录
     * @param recordReq
     * @return
     */
    List<RecordVO> findUserRecordList(RecordReq recordReq);

    /**
     * 创建一条用户记录
     * @param recordVo
     * @return
     */
    int createRecord(RecordVO recordVo);
}
