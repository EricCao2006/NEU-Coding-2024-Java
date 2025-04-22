package Exp3.Coffee;

/**返回纯文本格式的销售信息*/
public class PlainTextSalesFormatter implements SalesFormatter {

    /**唯一实例*/
    static PlainTextSalesFormatter singletonInstance;

    /**私有构造函数，防止外部创建实例*/
    private PlainTextSalesFormatter(){
        ;  //啥也不做
    }

    /**静态工厂方法，返回唯一实例*/
    static public PlainTextSalesFormatter getSingletonInstance(){
        if(singletonInstance == null){
            singletonInstance = new PlainTextSalesFormatter();
        }
        return singletonInstance;
    }

    /**
     * 实现接口方法
     * 格式化销售信息
     * @return 返回格式如下:<p>
     * ------------------------<p>
     * Order 订单序号<p>
     * <br>
     * quantity1 code1 price1<p>
     * quantity2 code2 price2<p>
     * ...<p>
     * quantityN codeN priceN<p>
     * <br>
     * Total = totalCost
     */
    public String formatSales(Sales sales){
        //临时变量声明
        String result = "";
        int orderNumber = 1;
        //下面均用加法
        //迭代器遍历
        for(Order order : sales) {
            result += "------------------------\n";
            result += "Order " + orderNumber+ "\n";
            result += "\n";
            for(OrderItem item : order){
                result += item.toString() + "\n";
            }
            result += "Total = " + order.getTotalCost() + "\n";
            orderNumber++;
        }
        result += "\n";
        return result;
    }

}
