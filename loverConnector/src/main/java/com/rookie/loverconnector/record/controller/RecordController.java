package com.rookie.loverconnector.record.controller;

import com.rookie.loverconnector.record.service.RecordService;
import com.rookie.loverconnector.record.vo.RecordVO;
import com.rookie.loverconnector.record.vo.request.RecordListReq;
import com.rookie.loverconnector.vo.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

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
    public MsgResponse<Map> getUserRecord(@Validated @RequestBody RecordListReq recordListReq) {
        MsgResponse<Map> msgResponse = new MsgResponse<>();
        Map userRecordList = recordService.findUserRecordList(recordListReq);
        msgResponse.setData(userRecordList);
        return msgResponse;
    }

    @PostMapping("createRecord")
    @ApiOperation(value = "创建一条记录", httpMethod = "POST")
    public MsgResponse createRecord(@Validated(RecordVO.CreateRecord.class) @RequestBody  RecordVO recordVo) {
        int result = recordService.createRecord(recordVo);
        if(result == 1) {
            return MsgResponse.success("操作成功！");
        }
        return  MsgResponse.fail("请求出错");
    }

    @PostMapping("updateRecord")
    @ApiOperation(value = "更新一条记录", httpMethod = "POST")
    public MsgResponse updateRecord(@Validated(RecordVO.UpdateRecord.class) @RequestBody RecordVO recordVO) {
        int result = recordService.updateRecord(recordVO);
        if(result != 0) {
            return  MsgResponse.success("操作成功！");
        }
        return MsgResponse.fail("请求出错");
    }

    @PostMapping("deleteRecord")
    @ApiOperation(value = "删除一条记录", httpMethod = "POST")
    public MsgResponse deleteRecord(@Validated(RecordVO.DeleteRecord.class) @RequestBody RecordVO recordVO) {
        recordService.deleteRecord(recordVO.getId());
        return MsgResponse.success("操作成功！");
    }

    @PostMapping("getRecordDetail")
    @ApiOperation(value = "获取记录详情", httpMethod = "POST")
    public MsgResponse getRecordDetail(@Validated(RecordVO.Detail.class) @RequestBody RecordVO recordVO) {
         RecordVO record = recordService.getRecordDetail(recordVO.getId());
         return MsgResponse.success(record);
    }
}
