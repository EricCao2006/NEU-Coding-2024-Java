package Exp4.Coffee;

/**
 * 返回 XML 格式的销售信息
 */
public class XMLSalesFormatter implements SalesFormatter {
    /**唯一实例*/
    static XMLSalesFormatter singletonInstance;

    /**私有构造函数，防止外部创建实例*/
    private XMLSalesFormatter(){
        ;  //啥也不做
    }

    /**静态工厂方法，返回唯一实例*/
    static public XMLSalesFormatter getSingletonInstance(){
        if(singletonInstance == null){
            singletonInstance = new XMLSalesFormatter();
        }
        return singletonInstance;
    }

    /**
     * 实现接口方法
     * 格式化销售信息
     * @return 返回格式如下:<p>
     * <Sales>
     *  <Order total="totalCost">
     *     <OrderItem quantity="quantity1" price="price1">code1</OrderItem>
     *     ...
     *     <OrderItem quantity="quantityN" price="priceN">codeN</OrderItem>
     *  </Order>
     *</Sales>
     */
    public String formatSales(Sales sales){
        //临时变量声明
        String result = "";
        //打印表头
        result += "<Sales>\n";
        //下面均用加法
        //迭代器遍历
        for(Order order : sales) {
            result += "<Order total=\"" + order.getTotalCost() + "\">\n";
            for(OrderItem item : order){
                Product product = item.getProduct();
                result += "<OrderItem quantity=\"" + item.getQuantity() + "\"";
                result += " price=\"" + product.getPrice() + "\">";
                result += product.getCode();
                result += "</OrderItem>\n";
            }
            result += "</Order>\n";
        }
        //打印表尾
        result += "</Sales>";
        return result;
    }

}
