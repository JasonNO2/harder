package org.jason.model;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:41 2017/12/25
 * @Modified By:
 */
public class Order {
    private String billid;
    private Double total;
    private String maker;

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Order() {
    }
}
