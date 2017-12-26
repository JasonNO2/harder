package org.jason.mapper;

import org.apache.ibatis.annotations.Param;
import org.jason.model.Order;
import org.jason.model.Order_detail;

import java.util.List;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:43 2017/12/25
 * @Modified By:
 */
public interface OrderMapper {
    List<Order_detail> findAlld(@Param("billid") String billid);
    List<Order> findAll();
    void addOrder(@Param("order") Order order);
    void addOrderd(@Param("order_detail") Order_detail order_detail);
}
