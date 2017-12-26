package org.jason.serviceImpl;

import org.jason.mapper.OrderMapper;
import org.jason.model.Order;
import org.jason.model.Order_detail;
import org.jason.model.Orders;
import org.jason.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:51 2017/12/25
 * @Modified By:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Override
    public List<Order_detail> findAlld(String billid) {
        return orderMapper.findAlld(billid);
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    @Transactional
    public void addOrder(Orders orders) {
        Order order=orders.getO();
        List<Order_detail> order_details=orders.getOs();
        orderMapper.addOrder(order);
        for (int i = 0; i < order_details.size(); i++) {
            Order_detail order_detail =  order_details.get(i);
            orderMapper.addOrderd(order_detail);
        }
    }
}
