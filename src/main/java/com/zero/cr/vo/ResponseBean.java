package com.zero.cr.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 返回的 data 数据结构：
 *     Map [String， Object]
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {

    @Builder.Default
    private Integer code = 1;
    @Builder.Default
    private String msg = "success";
    private Object data;
}
