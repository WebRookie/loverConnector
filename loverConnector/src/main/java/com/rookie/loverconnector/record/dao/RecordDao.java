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

    /**
     * 查询用户记录
     * @param recordReq
     * @return
     */
    Page<RecordVO> getRecordList(RecordReq recordReq);

    /**
     * 创建一条记录
     * @param recordVo
     */
    void createRecord(RecordVO recordVo);

    /**
     * 根据id查询记录
     * @param id
     * @return
     */
    RecordVO getRecordById(Integer id);

    /**
     * 更新记录
     * @param recordVO
     * @return
     */
    int updateRecord(RecordVO recordVO);

    /**
     * 删除用户记录
     * @param id
     */
    void deleteRecord(Integer id);
}
