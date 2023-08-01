package com.rookie.loverconnector.record.dao;

import com.github.pagehelper.Page;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordReq;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WebRookie
 * @date 2023/8/1 20:08
 **/
@Mapper
public interface RecordDao {

    Page<RecordVO> getRecordList(RecordReq recordReq);
}
