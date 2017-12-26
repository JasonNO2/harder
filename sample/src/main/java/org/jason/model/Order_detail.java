package org.jason.model;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 14:42 2017/12/25
 * @Modified By:
 */
public class Order_detail {
    private String billid;
    private String goodid;
    private String goodname;
    private Double goodprice;
    private Integer quantity;

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Double getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Double goodprice) {
        this.goodprice = goodprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order_detail() {
    }
}
