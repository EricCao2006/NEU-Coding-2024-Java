package Exp3.Coffee;

import java.util.ArrayList;
import java.util.Iterator;

/**产品目录类*/
public class Catalog implements Iterable<Product> {

    //成员变量

    /**产品列表*/
    private ArrayList<Product> products;


    /**新建空产品目录*/
    public Catalog() {
        products = new ArrayList<Product>();
    }


    //成员方法

    /**添加产品到目录*/
    public void addProduct(Product product) {
        products.add(product);
    }

    /**获取产品列表*/
    public Iterator<Product> iterator(){
        return products.iterator();
    }

    /**
     * 获取产品
     * @param code 产品代码
     * @return 产品对象或null
     */
    public Product getProduct(String code){
        for(Product product : products){
            if(product.getCode().equals(code)){
                return product;
            }
        }
        return null;
    }

    /**获取产品数量*/
    public int getNumberOfProducts(){
        return products.size();
    }
}