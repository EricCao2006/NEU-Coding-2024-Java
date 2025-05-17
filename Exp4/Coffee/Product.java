package Exp4.Coffee;

/**
 * 产品类
 * @see Coffee
 * @see CoffeeBrewer
 * @see OrderItem
 */
public class Product {

    //成员变量

    /**产品编号*/
    private String code;
    /**产品描述*/
    private String description;
    /**产品价格*/
    private double price;


    /**
     * 构造函数
     * 不必更改，因此不写setter方法
     * @param initialCode 产品编号
     * @param initialDescription 产品描述
     * @param initialPrice 产品价格
     */
	public Product (String initialCode,
                     String initialDescription,
                     double initialPrice){
        code = initialCode;
        description = initialDescription;
        price = initialPrice;
    }


    //getter方法

	public String getCode(){
        return code;
    }

	public String getDescription(){
        return description;
    }

	public double getPrice(){
        return price;
    }

    /**
     * 重写equals方法
     * 只比较产品编号code即可
     */
    @Override
    public boolean equals(Object object){
        //先问是不是
        if(object instanceof Product product){
            //再问同不同
            return code.equals(product.getCode());
        }
        return false;
    }

    /**
     * 重写toString方法
     * @return code_description_price
     */
    @Override
    public String toString(){
        return code + "_" + description + "_" + price ;
    }

}