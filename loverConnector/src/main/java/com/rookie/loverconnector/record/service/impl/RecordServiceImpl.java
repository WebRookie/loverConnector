package com.rookie.loverconnector.record.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rookie.loverconnector.record.dao.RecordDao;
import com.rookie.loverconnector.record.service.RecordService;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordListReq;
import com.rookie.loverconnector.user.dao.UserDao;
import com.rookie.loverconnector.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map findUserRecordList(RecordListReq recordListReq) {
        PageHelper.startPage(recordListReq.getPageNo(), recordListReq.getPageSize());
        List<RecordVO> recordList = recordDao.getRecordList(recordListReq.getParam());
        PageInfo pageInfo = new PageInfo(recordList);
        log.info("分页信息：" + pageInfo);
        HashMap map = new HashMap<>(2);
        map.put("list",recordList);
        map.put("total", pageInfo.getTotal());
        return map;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRecord(RecordVO recordVO) {
        return recordDao.updateRecord(recordVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRecord(Integer id) {
        recordDao.deleteRecord(id);
    }

    @Override
    public RecordVO getRecordDetail(Integer id) {
        return recordDao.getRecordById(id);
    }
}
