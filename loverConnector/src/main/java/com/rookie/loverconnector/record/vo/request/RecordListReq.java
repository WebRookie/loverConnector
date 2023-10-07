package com.rookie.loverconnector.record.vo.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author WebRookie
 * @date 2023/8/1 20:18
 **/
@Data
public class RecordListReq {

    @Min(value = 1, message = "查询数量必须大于1")
    @NotNull
    private Integer pageSize;

    @Min(value = 1, message = "起始页面必须大于0")
    @NotNull
    private Integer pageNo;


    @NotNull(message = "param不能为空")
    @Valid
    private RecordReq param;
}
