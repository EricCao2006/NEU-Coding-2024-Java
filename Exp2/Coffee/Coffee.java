package Exp2.Coffee;

/**咖啡类*/
public class Coffee extends Product {

    //成员变量

    /**
     * 继承自Product类：
     * private String code;
     * private String description;
     * private double price;
     */

    //咖啡特有属性
    /**原产地*/
    private String origin;
    /**烘焙程度*/
    private String roast;
    /**风味*/
    private String flavor;
    /**香气*/
    private String aroma;
    /**酸度*/
    private String acidity;
    /**醇厚度*/
    private String body;


    /**
     * 构造函数
     * 同Product类，不写setters方法
     *
     * @param initialCode        商品编码
     * @param initialDescription 商品描述
     * @param initialPrice       商品价格
     * @param initialOrigin      原产地
     * @param initialRoast       烘焙程度
     * @param initialFlavor      风味
     * @param initialAroma       香气
     * @param initialAcidity     酸度
     * @param initialBody        醇厚度
     */
    public Coffee(String initialCode,
                  String initialDescription,
                  double initialPrice,
                  String initialOrigin,
                  String initialRoast,
                  String initialFlavor,
                  String initialAroma,
                  String initialAcidity,
                  String initialBody) {
        super(initialCode, initialDescription, initialPrice);
        this.origin = initialOrigin;
        this.roast = initialRoast;
        this.flavor = initialFlavor;
        this.aroma = initialAroma;
        this.acidity = initialAcidity;
        this.body = initialBody;
    }


    //getter方法

    public String getOrigin() {
        return origin;
    }

    public String getRoast() {
        return roast;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getAroma() {
        return aroma;
    }

    public String getAcidity() {
        return acidity;
    }

    public String getBody() {
        return body;
    }

    /**
     * 覆写toString方法，
     * @return code_description_price_origin_roast_flavor_aroma_acidity_body
     */
    @Override
    public String toString() {
        return super.toString() + "_" + origin + "_" + roast + "_" + flavor + "_" + aroma + "_" + acidity + "_" + body;
    }

}