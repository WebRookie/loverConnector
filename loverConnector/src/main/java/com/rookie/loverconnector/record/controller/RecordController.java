package com.rookie.loverconnector.record.controller;

import com.github.pagehelper.PageHelper;
import com.rookie.loverconnector.record.service.RecordService;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordListReq;
import com.rookie.loverconnector.vo.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("getUserRecord")
    @ApiOperation(value = "获取用户记录", httpMethod="POST")
    public MsgResponse<List<RecordVO>> getUserRecord(@Validated @RequestBody RecordListReq recordListReq) {
        MsgResponse<List<RecordVO>> msgResponse = new MsgResponse<>();
        List<RecordVO> userRecordList = recordService.findUserRecordList(recordListReq.getRecordReq());
        msgResponse.setData(userRecordList);
        return msgResponse;
    }

    @PostMapping("createRecord")
    @ApiOperation(value = "创建一条记录", httpMethod = "POST")
    public MsgResponse createRecord(@Validated(RecordVO.CreateRecord.class) @RequestBody  RecordVO recordVo) {
        int result = recordService.createRecord(recordVo);
        if(result == 1) {
            return MsgResponse.success();
        }
        return  MsgResponse.fail("请求出错");
    }
}
