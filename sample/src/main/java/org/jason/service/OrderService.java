package org.jason.service;

import org.jason.model.Order;
import org.jason.model.Order_detail;
import org.jason.model.Orders;

import java.util.List;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:50 2017/12/25
 * @Modified By:
 */
public interface OrderService {
    List<Order_detail> findAlld(String billid);
    List<Order> findAll();
    void addOrder(Orders orders);
}
