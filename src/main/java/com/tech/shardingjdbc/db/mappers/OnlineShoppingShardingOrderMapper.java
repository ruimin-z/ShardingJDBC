package com.tech.shardingjdbc.db.mappers;

import com.tech.shardingjdbc.db.po.OnlineShoppingShardingOrder;

import java.util.List;
import java.util.Map;

public interface OnlineShoppingShardingOrderMapper {
//    int deleteByPrimaryKey(Long commodityId);

    int insert(OnlineShoppingShardingOrder record);


    OnlineShoppingShardingOrder queryOrder(Long orderId, Long userId);

    int insertSharding(OnlineShoppingShardingOrder order);
}