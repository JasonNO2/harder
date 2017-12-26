package org.jason.controller;

import org.jason.model.Order;
import org.jason.model.Order_detail;
import org.jason.model.Orders;
import org.jason.serviceImpl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:50 2017/12/25
 * @Modified By:
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    OrderServiceImpl orderServiceImpl;

    @RequestMapping("toAdd")
    String String(){
        return "AddOrder";
    }
    @RequestMapping("show")
    String show(){
        return "Orders";
    }
    @RequestMapping("create")
    @ResponseBody
    boolean create(@RequestBody Orders orders){
        boolean flag=true;
        try {
            orderServiceImpl.addOrder(orders);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
    @RequestMapping("all")
    @ResponseBody
    List<Order> all(){
       return orderServiceImpl.findAll();
    }
    @RequestMapping("alld/{billid}")
    @ResponseBody
    List<Order_detail> alld(@PathVariable String billid){
        return orderServiceImpl.findAlld(billid);
    }
}
