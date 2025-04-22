package Exp3.Coffee;

/**返回 HTML 格式的销售信息*/
public class HTMLSalesFormatter implements  SalesFormatter {

    /**唯一实例*/
    static HTMLSalesFormatter singletonInstance;

    /**私有构造函数，防止外部创建实例*/
    private HTMLSalesFormatter(){
        ;  //啥也不做
    }

    /**静态工厂方法，返回唯一实例*/
    static public HTMLSalesFormatter getSingletonInstance(){
        if(singletonInstance == null){
            singletonInstance = new HTMLSalesFormatter();
        }
        return singletonInstance;
    }

    /**
     * 实现接口方法
     * 格式化销售信息
     * @return 返回格式如下:<p>
     * <html>
     *   <body>
     *     <center><h2>Orders</h2></center>
     *         <hr>
     *         <h4>Total = totalCost</h4>
     *           <p>
     *             <b>code:</b> code1<br>
     *             <b>quantity:</b> quantity1<br>
     *             <b>price:</b> price1
     *          </p>
     *           ...
     *          <p>
     *             <b>code:</b> codeN<br>
     *             <b>quantity:</b> quantityN<br>
     *             <b>price:</b> priceN
     *          </p>
     *   </body>
     * </html>
     */
    public String formatSales(Sales sales){
        //临时变量声明
        String result = "";
        //打印表头
        result += "<html>\n";
        result += "  <body>\n";
        result += "    <center><h2>Orders</h2></center>\n";
        //下面均用加法
        //迭代器遍历
        for(Order order : sales) {
            result += "<hr>\n";
            result += "<h4>Total = " + order.getTotalCost() + "</h4>\n";
            for(OrderItem item : order){
                Product product = item.getProduct();
                result += "<p>\n";
                result += "  <b>code:</b> " + product.getCode() + "<br>\n";
                result += "  <b>quantity:</b> " + item.getQuantity() + "<br>\n";
                result += "  <b>price:</b> " + product.getPrice() + "\n";
                result += "</p>\n";
            }
        }
        //打印表尾
        result += "  </body>\n";
        result += "</html>\n";
        return result;
    }

}
