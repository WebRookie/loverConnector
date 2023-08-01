package com.rookie.loverconnector.record.service;

import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordReq;

import java.util.List;

/**
 * @author WebRookie
 * @date 2023/8/1 20:39
 **/
public interface RecordService {


    List<RecordVO> findUserRecordList(RecordReq recordReq);
}
