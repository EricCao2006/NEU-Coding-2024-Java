# 数据格式说明

本文件描述了系统中各类商品的数据格式，所有字段使用下划线 `_` 分隔。

## 咖啡 (Coffee)
格式：`Coffee_<code>_<description(a,b,c)>_<price>_<origin>_<roast>_<flavor(a and b)>_<aroma>_<acidity>_<body>`

字段说明：
- `code`: 商品编号（字符串）
- `description`: 商品描述（字符串）
- `price`: 价格（浮点数）
- `origin`: 原产地（字符串）
- `roast`: 烘焙程度（字符串）
- `flavor`: 风味（字符串）
- `aroma`: 香气（字符串）
- `acidity`: 酸度（字符串）
- `body`: 浓重度（字符串）

示例：
Coffee_C001_Colombia, Whole, 1 lb_17.99_Colombia_Medium_Rich and Hearty_Rich_Medium_Full

## 咖啡机 (Brewer)
格式：`Brewer_<code>_<description>_<price>_<model>_<waterSupply>_<numberOfCups>`

字段说明：
- `code`: 商品编号（字符串）
- `description`: 商品描述（字符串）
- `price`: 价格（浮点数）
- `model`: 型号（字符串）
- `waterSupply`: 是否内置水箱（布尔值，表示为 "true"/"false"）
- `numberOfCups`: 一次可制作的杯数（整数）

示例：Brewer_BR002_AutomaticCoffeeMaker_199.99_Espresso_true_4

## 配件 (Product)
格式：`Product_<code>_<description>_<price>`

字段说明：
- `code`: 商品编号（字符串）
- `description`: 商品描述（字符串）
- `price`: 价格（浮点数）

示例：Product_P123_CoffeeFilter_5.99
