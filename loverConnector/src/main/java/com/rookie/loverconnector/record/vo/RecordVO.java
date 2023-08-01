package com.rookie.loverconnector.record.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @author WebRookie
 * @date 2023/8/1 19:21
 **/
@Data
@ApiModel("记录VO")
public class RecordVO {

    @ApiModelProperty(value = "记录Id")
    private Integer id;

    @ApiModelProperty(value = "用户Id")
    private Integer userId;

    @ApiModelProperty(value = "记录类型：1-收入、2-支出")
    private String recordType;

    @ApiModelProperty(value = "记录内容")
    private String recordContent;

    @ApiModelProperty(value = "记录类型，例如：红包、")
    private String moneyKind;

    @ApiModelProperty(value = "金额")
    private Double price;

    @ApiModelProperty(value = "创建时间")
    private Date createData;

    @ApiModelProperty(value = "修改时间")
    private Date updateData;
}
