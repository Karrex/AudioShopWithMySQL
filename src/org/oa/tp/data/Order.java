package org.oa.tp.data;

/**
 * Created by Eugene on 02.06.2015.
 */
public class Order {
    private final int id;
    private String goods;
    private String dateOrder;
    private String deliveryPeriod;

    public Order(int id, String goods, String dateOrder, String deliveryPeriod) {
        this.id = id;
        this.goods = goods;
        this.dateOrder = dateOrder;
        this.deliveryPeriod = deliveryPeriod;
    }

    public Order(String goods, String dateOrder, String deliveryPeriod) {
        id = 0;
        this.goods = goods;
        this.dateOrder = dateOrder;
        this.deliveryPeriod = deliveryPeriod;
    }

    public int getId() {
        return id;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goods='" + goods + '\'' +
                ", dateOrder='" + dateOrder + '\'' +
                ", deliveryPeriod='" + deliveryPeriod + '\'' +
                '}';
    }
}
