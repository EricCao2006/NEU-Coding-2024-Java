package Exp4.Coffee;

/**咖啡机类*/
public class CoffeeBrewer extends Product {

    //成员变量

    /**
     * 继承自Product类：
     * private String code;
     * private String description;
     * private double price;
     */

    //特有属性
    /**咖啡机型号*/
    private String model;
    /**供水方式*/
    private String waterSupply;
    /**咖啡机杯数*/
    private int numberOfCups;


    /**
     * 构造函数
     * 同Product类，不写setters方法
     * @param initialCode 产品编码
     * @param initialDescription 产品描述
     * @param initialPrice 产品价格
     * @param initialModel 咖啡机型号
     * @param initialWaterSupply 供水方式
     * @param initialNumberOfCups 咖啡机杯数
     */
    public CoffeeBrewer(String initialCode,
                        String initialDescription,
                        double initialPrice,
                        String initialModel,
                        String initialWaterSupply,
                        int initialNumberOfCups){
        super(initialCode, initialDescription, initialPrice);
        this.model = initialModel;
        this.waterSupply = initialWaterSupply;
        this.numberOfCups = initialNumberOfCups;
    }


    //getters方法
    public String getModel(){
        return this.model;
    }

    public String getWaterSupply(){
        return this.waterSupply;
    }

    public int getNumberOfCups(){
        return this.numberOfCups;
    }

    /**
     * 重写toString方法
     * @return code_description_price_model_waterSupply_numberOfCups
     */
    @Override
    public String toString(){
        return super.toString() + "_" + this.model + "_" + this.waterSupply + "_" + this.numberOfCups;
    }

}