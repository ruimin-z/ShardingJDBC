package com.tech.shardingjdbc.db.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
public class OnlineShoppingShardingOrder {
    private Long orderId;

    private String orderNo;

    private Integer orderStatus;

    private Long commodityId;

    private Long userId;

    private Long orderAmount;

    private Date createTime;

    private Date payTime;

}