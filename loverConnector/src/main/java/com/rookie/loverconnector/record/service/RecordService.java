package com.rookie.loverconnector.record.service;

import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordListReq;

import java.util.Map;

/**
 * @author WebRookie
 * @date 2023/8/1 20:39
 **/
public interface RecordService {


    /**
     * 查询用户记录
     * @param recordListReq
     * @return
     */
    Map findUserRecordList(RecordListReq recordListReq);

    /**
     * 创建一条用户记录
     * @param recordVo
     * @return
     */
    int createRecord(RecordVO recordVo);

    /**
     * 更改用户记录
     * @param recordVO
     * @return
     */
    int updateRecord(RecordVO recordVO);

    /**
     * 删除用户记录（软删除）
     * @param id
     */
    void deleteRecord(Integer id);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    RecordVO getRecordDetail(Integer id);
}
