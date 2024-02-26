package com.tech.shardingjdbc.db.dao;

import com.tech.shardingjdbc.db.po.OnlineShoppingShardingOrder;


public interface OnlineShoppingShardingOrderDao {

    int insert(OnlineShoppingShardingOrder order);

    int insertSharding(OnlineShoppingShardingOrder order);

    OnlineShoppingShardingOrder queryOrder(Long orderId, Long userId);
}