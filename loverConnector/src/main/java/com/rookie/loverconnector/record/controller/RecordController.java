package com.rookie.loverconnector.record.controller;

import com.github.pagehelper.PageHelper;
import com.rookie.loverconnector.record.service.RecordService;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordListReq;
import com.rookie.loverconnector.vo.MsgResponse;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WebRookie
 * @date 2023/8/1 19:20
 **/
@RestController
@Api(value="记录controller", tags = "记录相关接口")
@RequestMapping("/record")
public class RecordController {

    @Resource
    private RecordService recordService;

    public MsgResponse<RecordVO> getUserRecord(@Validated RecordListReq recordListReq) {
        PageHelper.startPage(recordListReq.getPageNo(), recordListReq.getPageSize());
        List<RecordVO> recordList = recordService.findUserRecordList(recordListReq.getRecordReq());
    }
}
