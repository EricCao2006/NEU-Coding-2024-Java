package Exp4.Coffee;

import java.util.ArrayList;
import java.util.Iterator;

/**订单列表类*/
public class Sales implements Iterable<Order> {

    //成员变量

    /**订单列表*/
    private ArrayList<Order> orderList;


    /**新建空订单列表*/
    public Sales() {
        orderList = new ArrayList<Order>();
    }

    /**添加订单*/
    public void addOrder(Order order) {
        orderList.add(order);
    }

    /**获取订单列表*/
    public Iterator<Order> iterator() {
        return orderList.iterator();
    }

    /**获取订单总数*/
    public int getNumberOfOrders() {
        return orderList.size();
    }

}
