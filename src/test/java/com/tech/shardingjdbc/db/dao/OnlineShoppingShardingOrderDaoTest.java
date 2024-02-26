package com.tech.shardingjdbc.db.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tech.shardingjdbc.db.po.OnlineShoppingShardingOrder;
import com.tech.shardingjdbc.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper; // Java 中用于处理 JSON 数据的类库
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OnlineShoppingShardingOrderDaoTest {

    @Resource
    OnlineShoppingShardingOrderDao orderDao;


    ObjectMapper objectMapper = new ObjectMapper(); // java对象转json字符串

    @Test
    void insert_order_schema_online_shopping_2() {
        for (int i = 0; i < 100; i++) {
            long orderId = i + 100L;
            OnlineShoppingShardingOrder order =
                    OnlineShoppingShardingOrder.builder()
                            .orderStatus(0)
                            .orderNo("123")
                            .orderId(orderId)
                            .orderAmount(123L)
                            .commodityId(123L)
                            .createTime(new Date())
                            .payTime(new Date())
                            .userId(123L)
                            .orderStatus(0)
                            .build();

            orderDao.insertSharding(order);
        }
    }

    @Test
    void insert_order_schema_online_shopping_1() {
        for (int i = 0; i < 100; i++) {
            long orderId = i + 500L;
            OnlineShoppingShardingOrder order =
                    OnlineShoppingShardingOrder.builder()
                            .orderStatus(0)
                            .orderNo("123")
                            .orderId(orderId)
                            .orderAmount(123L)
                            .commodityId(123L)
                            .createTime(new Date())
                            .payTime(new Date())
                            .userId(124L)
                            .orderStatus(0)
                            .build();
            orderDao.insertSharding(order);
        }
    }

    @Test
    void queryShardingOrder() throws JsonProcessingException {
        Long orderId = 101L;
        OnlineShoppingShardingOrder onlineShoppingShardingOrder1 = orderDao.queryOrder(orderId, 123L);
        OnlineShoppingShardingOrder onlineShoppingShardingOrder2 = orderDao.queryOrder(orderId+1, 123L);
//        log.info("order1:", objectMapper.writeValueAsString(onlineShoppingShardingOrder1));
//        log.info("order2:", objectMapper.writeValueAsString(onlineShoppingShardingOrder2));
        log.info("order1:{}", onlineShoppingShardingOrder1);
        log.info("order2:{}", onlineShoppingShardingOrder2);
    }

    @Test
    void insert_order_schema_online_shopping_SnowFlake() {
        SnowflakeIdWorker snowFlake = new SnowflakeIdWorker(1,1); // 模拟。定死了workerid和datacenterid
        List<OnlineShoppingShardingOrder> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            long orderId = snowFlake.nextId();
            System.out.println(orderId);
            OnlineShoppingShardingOrder order =
                    OnlineShoppingShardingOrder.builder()
                            .orderStatus(0)
                            .orderNo("123")
                            .orderId(orderId)
                            .orderAmount(123L)
                            .commodityId(123L)
                            .createTime(new Date())
                            .payTime(new Date())
                            .userId(124L)
                            .orderStatus(0)
                            .build();
            orders.add(order);
        }
        for (int i = 0; i < 100; i++) {
            orderDao.insertSharding(orders.get(i));
        }
    }
}