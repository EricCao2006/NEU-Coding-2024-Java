package Exp3.Coffee;

import java.util.ArrayList;
import java.util.Iterator;

/**订单类*/
public class Order implements Iterable<OrderItem> {

    //成员变量

    /**订单列表*/
    private ArrayList<OrderItem> items;


    //成员方法

    /**新建空订单*/
    public Order() {
        items = new ArrayList<OrderItem>();
    }

    /**添加订单项*/
    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    /**移除订单项*/
    public void removeItem(OrderItem orderItem){
        items.remove(orderItem);
    }

    /**获取订单项列表的迭代器*/
    public Iterator<OrderItem> iterator(){
        return items.iterator();
    }

    /**
     * 获取单个订单项
     * @param product 产品对象
     * @return 订单项或null
     */
    public OrderItem getItem(Product product){
        for(OrderItem item : items){
            if(item.getProduct().equals(product)){
                return item;
            }
        }
        return null;
    }

    /**获取订单项目总数*/
    public int getNumberOfItems(){
        return items.size();
    }

    /**结账
     * @return 订单总金额
     */
    public double getTotalCost(){
        double totalCost = 0;
        for(OrderItem item : items){
            totalCost += item.getQuantity() * item.getProduct().getPrice();
        }
        return totalCost;
    }

}