package com.rookie.loverconnector.record.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @author WebRookie
 * @date 2023/8/1 20:31
 **/
@Data
public class RecordReq {
    public interface Search {}

    @NotNull(message = "userId不能为空", groups = {Search.class})
    private Integer userId;

    private Date createDate;
}
