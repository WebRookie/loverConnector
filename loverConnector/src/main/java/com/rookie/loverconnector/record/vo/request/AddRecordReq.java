package com.rookie.loverconnector.record.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author WebRookie
 * @date 2023/8/3 20:00
 **/
@Data
public class AddRecordReq {

    public interface AddRecord {}

    public interface UpdateRecord {}


    @NotNull(message = "记录id必传", groups = { UpdateRecord.class})
    private Integer id;

    @NotNull( groups = { AddRecord.class, UpdateRecord.class})
    private Integer userId;

    @NotNull( groups = { AddRecord.class, UpdateRecord.class})
    private String recordType;


    private String moneyKind;

    /**
     * 用整数，存入的值设置成 分钱 * 10 ，避免小数导致计算精度丢失的问题。
     */
    @NotNull( groups = { AddRecord.class, UpdateRecord.class})
    private Integer price;

    @Size(max = 400, message = "最多输入400个字符")
    @NotNull( groups = { AddRecord.class, UpdateRecord.class})
    private String recordContent;
}
