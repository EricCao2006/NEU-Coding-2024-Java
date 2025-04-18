package Coffee;

/**
 * 订单项目类
 */
public class OrderItem {

    //成员变量

    //产品
    private Product product;
    //数量
    private int quantity;


    /**
     * 构造函数
     * @param initialProduct 产品
     * @param initialQuantity 数量
     */
    public OrderItem(Product initialProduct,
                 int initialQuantity){
        product = initialProduct;
        quantity = initialQuantity;
    }


    //getter方法

    public Product getProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }

    /**
     * 计算总价
     * @return 单价乘数量
     */
    public double getValue(){
        return product.getPrice() * quantity;
    }


    //setter方法

    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }


    /**
     * 覆写toString方法，
     * @return 数量(空格)产品编号(空格)价格
     */
    @Override
    public String toString(){
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }

}