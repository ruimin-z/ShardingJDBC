package com.tech.shardingjdbc.db.dao.impl;

import com.tech.shardingjdbc.db.dao.OnlineShoppingShardingOrderDao;
import com.tech.shardingjdbc.db.mappers.OnlineShoppingShardingOrderMapper;
import com.tech.shardingjdbc.db.po.OnlineShoppingShardingOrder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OnlineShoppingShardingOrderDaoImpl implements OnlineShoppingShardingOrderDao{
    @Resource
    OnlineShoppingShardingOrderMapper mapper;

    @Override
    public int insert(OnlineShoppingShardingOrder order) {
        return mapper.insert(order);
    }

    @Override
    public int insertSharding(OnlineShoppingShardingOrder order) {
        return mapper.insertSharding(order);
    }

    @Override
    public OnlineShoppingShardingOrder queryOrder(Long orderId, Long userId) {
        return mapper.queryOrder(orderId, userId);
    }
}