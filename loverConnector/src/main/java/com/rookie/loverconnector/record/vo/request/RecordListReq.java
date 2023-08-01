package com.rookie.loverconnector.record.vo.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author WebRookie
 * @date 2023/8/1 20:18
 **/
@Data
public class RecordListReq {

    @Min(value = 1, message = "查询数量必须大于1")
    private Integer pageSize;

    @Min(value = 1, message = "起始页面必须大于0")
    private Integer pageNo;

    @Valid
    private RecordReq recordReq;
}
