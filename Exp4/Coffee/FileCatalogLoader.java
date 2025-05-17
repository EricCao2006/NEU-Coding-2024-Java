package Exp4.Coffee;

import java.io.*;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader{

    /**
     * 加载文件数据并构建产品目录
     * @param fileName 文件名
     * @return 产品目录
     */
    @Override
    public Catalog loadCatalog(String fileName)throws DataFormatException, IOException, FileNotFoundException{
        Catalog catalog = new Catalog();
        //创建缓冲读取器
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                line = line.trim(); //去除空格
                if (line.isEmpty()) //空行不等同于没行
                    continue;
                try {
                    //将产品归类
                    if (line.startsWith("Product")) {
                        catalog.addProduct(readProduct(line));
                    } else if (line.startsWith("Coffee")) {
                        catalog.addProduct(readCoffee(line));
                    } else if (line.startsWith("Brewer")) {
                        catalog.addProduct(readCoffeeBrewer(line));
                    } else {
                        //产品类别不合法
                        throw new DataFormatException("Invalid line type at line " + lineNum + ": " + line);
                    }
                    //三个异常都处理后再重新抛出
                } catch (DataFormatException e) {
                    throw new DataFormatException("Error in line " + lineNum + ": " + e.getMessage());
                }
            }
        }catch(FileNotFoundException e){
            throw new FileNotFoundException("File not found: " + fileName);
        }catch(IOException e){
            throw new IOException("Error reading file: " + e.getMessage());
        }
        return catalog;
    }

    /**
     * 解析配件数据行
     * @param line
     * @return Product
     */
    private Product readProduct(String line) throws DataFormatException{
        //设置分隔符为"_"
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        //格式是Product_<code>_<description>_<price>
        //注意countTokens()返回分隔段的数量，所以这里需要+1
        if (tokenizer.countTokens() != 4)
            throw new DataFormatException("Invalid Product format: " + line);
        //文本串解析
        try {
            tokenizer.nextToken(); // 跳过Product前缀
            String code = tokenizer.nextToken();
            String description = tokenizer.nextToken();
            double price = Double.parseDouble(tokenizer.nextToken());
        // 返回产品对象
            return new Product(code, description, price);
        } catch (NumberFormatException e) {
            throw new DataFormatException("Invalid number format in Product: " + line);
        }
    }

    /**
     * 解析咖啡数据行
     * @param line
     * @return Coffee
     */
    private Coffee readCoffee(String line) throws DataFormatException{
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != 10)
            throw new DataFormatException("Invalid Coffee format: " + line);
        try {
            tokenizer.nextToken();
            String code = tokenizer.nextToken();
            String description = tokenizer.nextToken();
            double price = Double.parseDouble(tokenizer.nextToken());
            String origin = tokenizer.nextToken();
            String roast = tokenizer.nextToken();
            String flavor = tokenizer.nextToken();
            String aroma = tokenizer.nextToken();
            String acidity = tokenizer.nextToken();
            String body = tokenizer.nextToken();
            return new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);
        } catch (NumberFormatException e) {
            throw new DataFormatException("Invalid number format in Coffee: " + line);
        }
    }

    /**
     * 解析咖啡机数据行
     * @param line
     * @return CoffeeBrewer
     */
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != 7) {
            throw new DataFormatException("Invalid Brewer format: " + line);
        }
        try {
            tokenizer.nextToken(); // Skip "Brewer" prefix
            String code = tokenizer.nextToken();
            String description = tokenizer.nextToken();
            double price = Double.parseDouble(tokenizer.nextToken());
            String model = tokenizer.nextToken();
            String waterSupply = tokenizer.nextToken();
            int numberOfCups = Integer.parseInt(tokenizer.nextToken());
            return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);
        } catch (NumberFormatException e) {
            throw new DataFormatException("Invalid number format in Brewer: " + line);
        }
    }
}
