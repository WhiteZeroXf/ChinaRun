package com.zero.cr.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PLCountBean {

    /**
     * 日志ID
     */
    private  Long flashId;

    /**
     * 当前日志的评论数
     */

    private  int  count;
}
