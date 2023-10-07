package com.rookie.loverconnector.record.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WebRookie
 * @date 2023/8/1 19:21
 **/
@Data
@ApiModel("记录VO")
public class RecordVO {

    public interface CreateRecord {}

    @ApiModelProperty(value = "记录Id")
    private Integer id;

    @ApiModelProperty(value = "用户Id")
    @NotNull(message = "用户Id不能为空", groups = { CreateRecord.class })
    private Integer userId;

    @ApiModelProperty(value = "记录类型：1-收入、2-支出")
    @NotNull(message = "记录类型不能为空", groups = { CreateRecord.class })
    private String recordType;

    @ApiModelProperty(value = "记录内容")
    private String recordContent;

    @NotNull(message = "记录金额不能为空", groups = { CreateRecord.class })
    @ApiModelProperty(value = "金额")
    private BigDecimal price;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date updateDate;
}
