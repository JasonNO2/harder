package org.jason.model;

import java.util.List;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:59 2017/12/25
 * @Modified By:
 */
public class Orders {
    private Order o;
    private List<Order_detail> os;

    public Order getO() {
        return o;
    }

    public void setO(Order o) {
        this.o = o;
    }

    public List<Order_detail> getOs() {
        return os;
    }

    public void setOs(List<Order_detail> os) {
        this.os = os;
    }

    public Orders() {
    }
}
