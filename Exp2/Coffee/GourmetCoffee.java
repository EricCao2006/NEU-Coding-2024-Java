package Exp2.Coffee;

import java.io.*;
import java.text.*;

/**
 * "美味咖啡"订单系统
 * @see Product
 * @see Coffee
 * @see CoffeeBrewer
 * @see Catalog
 * @see OrderItem
 * @see Order
 * @see Sales
 */
public class GourmetCoffee  {

	//输入输出流
	private static BufferedReader stdIn =
		new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut =
		new PrintWriter(System.out, true);
	private static PrintWriter stdErr =
		new PrintWriter(System.err, true);

	//货币格式化
	private static final NumberFormat CURRENCY =
		NumberFormat.getCurrencyInstance();

	//成员变量
	private Catalog catalog;
	private Order currentOrder;
	private Sales sales;

	/**
	 * 载入产品目录，启动！
	 * @param args 智多星，无用[Doge]
	 * @throws IOException 一旦输入流有问题
	 */
	public static void main(String[] args) throws IOException{
		GourmetCoffee application = new GourmetCoffee();
		application.run();
	}

	/**初始化*/
	private GourmetCoffee() {
		this.catalog = loadCatalog();
		this.sales = loadSales(this.catalog);
		this.currentOrder = new Order();
	}

	/**
	 * 创建空产品目录并载入产品
	 * @return 产品目录
	 */
	private Catalog loadCatalog() {

		Catalog catalog = new Catalog();

		//A系列
		catalog.addProduct(
				new Product("A001", "Almond Flavored Syrup", 9.00));
		catalog.addProduct(
				new Product("A002", "Irish Creme Flavored Syrup", 9.00));
		catalog.addProduct(
				new Product("A003", "Mint Flavored syrup", 9.00));
		catalog.addProduct(
				new Product("A004", "Caramel Flavored Syrup", 9.00));
		catalog.addProduct(
				new Product("A005", "Gourmet Coffee Cookies", 12.00));

		//B系列
		catalog.addProduct(new CoffeeBrewer(
				"B001", "Home Coffee Brewer", 150.00,
				"Brewer 100", "Pourover", 6));
		catalog.addProduct(new CoffeeBrewer(
				"B002", "Coffee Brewer, 2 Warmers", 200.00,
				"Brewer 200", "Pourover", 12));
		catalog.addProduct(new CoffeeBrewer(
				"B003", "Coffee Brewer, 3 Warmers", 280.00,
				"Brewer 210", "Pourover", 12));

		//C系列
		catalog.addProduct(new Coffee(
			"C001", "Colombia, Whole, 1 lb", 17.99,
			"Colombia", "Medium", "Rich and Hearty", "Rich", "Medium", "Full"));
		catalog.addProduct(new Coffee(
			"C002", "Colombia, Ground, 1 lb", 18.75,
			"Colombia", "Medium", "Rich and Hearty", "Rich", "Medium","Full"));
		catalog.addProduct(new Coffee(
			"C003", "Italian Roasts, Whole, 1 lb", 16.80,
			"Latin American Blend", "Italian Roast", "Dark and heavy",
			"Intense", "Low", "Medium"));
		catalog.addProduct(new Coffee(
			"C004", "Italian Roasts, Ground, 1 lb", 17.55,
			"Latin American Blend", "Italian Roast", "Dark and heavy",
			"Intense", "Low", "Medium"));
		catalog.addProduct(new Coffee(
			"C005", "French Roasts, Whole, 1 lb", 16.80,
			"Latin American Blend", "French Roast", "Bittersweet, full intense",
			"Intense, full", "None", "Medium"));

		return catalog;
	}

	/**
	 * 创建空订单列表并载入订单
	 * @return 订单列表
	 */
	private Sales loadSales(Catalog catalog) {

		Sales sales = new Sales();
		Order[] orders = new Order[6];

		orders[0] = new Order();
		orders[0].addItem(new OrderItem(catalog.getProduct("C001"), 5));
		sales.addOrder(orders[0]);

		orders[1] = new Order();
		orders[1].addItem(new OrderItem(catalog.getProduct("C002"), 2));
		orders[1].addItem(new OrderItem(catalog.getProduct("A001"), 2));
		orders[1].addItem(new OrderItem(catalog.getProduct("A003"), 2));
		sales.addOrder(orders[1]);

		orders[2] = new Order();
		orders[2].addItem(new OrderItem(catalog.getProduct("B002"), 1));
		orders[2].addItem(new OrderItem(catalog.getProduct("A003"), 3));
		sales.addOrder(orders[2]);

		orders[3] = new Order();
		orders[3].addItem(new OrderItem(catalog.getProduct("B003"), 2));
		orders[3].addItem(new OrderItem(catalog.getProduct("C001"), 3));
		orders[3].addItem(new OrderItem(catalog.getProduct("C003"), 3));
		orders[3].addItem(new OrderItem(catalog.getProduct("C005"), 3));
		orders[3].addItem(new OrderItem(catalog.getProduct("A001"), 3));
		orders[3].addItem(new OrderItem(catalog.getProduct("A004"), 2));
		sales.addOrder(orders[3]);
		
		orders[4] = new Order();
		orders[4].addItem(new OrderItem(catalog.getProduct("B001"), 1));
		orders[4].addItem(new OrderItem(catalog.getProduct("C002"), 2));
		orders[4].addItem(new OrderItem(catalog.getProduct("C003"), 2));
		orders[4].addItem(new OrderItem(catalog.getProduct("A001"), 2));
		orders[4].addItem(new OrderItem(catalog.getProduct("A002"), 6));
		sales.addOrder(orders[4]);
		
		orders[5] = new Order();
		orders[5].addItem(new OrderItem(catalog.getProduct("B001"), 1));
		orders[5].addItem(new OrderItem(catalog.getProduct("C001"), 1));
		orders[5].addItem(new OrderItem(catalog.getProduct("C005"), 5));
		orders[5].addItem(new OrderItem(catalog.getProduct("A001"), 5));
		orders[5].addItem(new OrderItem(catalog.getProduct("A004"), 4));
		sales.addOrder(orders[5]);
		
		return sales;
	}

	/**选项菜单*/
	private void run() throws IOException  {

		int  choice = getChoice();

		while (choice != 0)  {

			if (choice == 1)  {
				displayCatalog(); //显示产品目录
			} else if (choice == 2)  {
				displayProductInfo(); //显示产品信息
			} else if (choice == 3)  {
				displayOrder(); //显示当前订单
			} else if (choice == 4)  {
				addModifyProduct(); //添加或修改产品到当前订单
			} else if (choice == 5)  {
				removeProduct(); //从当前订单移除产品
			} else if (choice == 6)  {
				saleOrder(); //注册当前订单的销售
			} else if (choice == 7)  {
				displayOrdersSold(); //显示已售订单
			} else if (choice == 8)  {
				displayNumberOfOrders(readProduct()); //显示指定产品的订单数量
			} else if (choice == 9)  {
				displayTotalQuantityOfProducts(); //显示每个产品的总销量
			} 

			choice = getChoice();
		}
	}

	/**
	 * 显示选项菜单，并获取用户的选择
	 * @return [0,7]范围内的整数
	 */
	private int getChoice() throws IOException  {

		int  input;

		do  {
			try  {
				stdErr.println();
				stdErr.print(
					  "[0] Quit\n"
					+ "[1] Display catalog\n"
					+ "[2] Display product\n"
					+ "[3] Display current order\n"
					+ "[4] Add|modify product to|in current order\n"
					+ "[5] Remove product from current order\n"
					+ "[6] Register sale of current order\n"
					+ "[7] Display sales\n"
					+ "[8] Display number of orders with a specific product\n"
					+ "[9] Display the total quantity sold for each product\n"
					+ "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();
				//输入范围检查
				if (0 <= input && 9 >= input)  {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe)  {
				stdErr.println(nfe);
			}
		}  while (true);

		return  input;
	}

	/**显示产品目录*/
	public void displayCatalog() {

		int size = this.catalog.getNumberOfProducts();
		//避免显示空白
		if (size == 0) {
			stdErr.println("The catalog is empty");
		} else {
			for (Product product : this.catalog) {
				stdOut.println(product.getCode() + " " +
					product.getDescription());
			}
		}
	}

	/**
	 * 显示产品信息，
	 * 格式为: "标签: 值"
	 */
	public void displayProductInfo() throws IOException  {

		Product product = readProduct();

		stdOut.println("  Description: " + product.getDescription());
		stdOut.println("  Price: " + product.getPrice());

		//特殊种类特殊处理
		if (product instanceof Coffee) {

			Coffee coffee = (Coffee) product;

			stdOut.println("  Origin: " + coffee.getOrigin());
			stdOut.println("  Roast: " + coffee.getRoast());
			stdOut.println("  Flavor: " + coffee.getFlavor());
			stdOut.println("  Aroma: " + coffee.getAroma());
			stdOut.println("  Acidity: " + coffee.getAcidity());
			stdOut.println("  Body: " + coffee.getBody());
		} else if (product instanceof CoffeeBrewer) {
			CoffeeBrewer brewer = (CoffeeBrewer) product;
			stdOut.println("  Model: " + brewer.getModel());
			stdOut.println("  Water Supply: " + brewer.getWaterSupply());
			stdOut.println("  Number of Cups: " + brewer.getNumberOfCups());
		}
	}

	/**显示当前订单*/
	public void displayOrder() {

		int size = this.currentOrder.getNumberOfItems();
		//空订单报错
		if (size == 0) {
			stdErr.println("The current order is empty");
		} else {
			for (OrderItem orderItem : this.currentOrder) {
				stdOut.println(orderItem.toString());
			}
			stdOut.println("Total: " +
				CURRENCY.format(this.currentOrder.getTotalCost()));
		}
	}

	/**添加或修改产品到当前订单*/
	public void addModifyProduct() throws IOException {

		Product product = readProduct();
		int quantity = readQuantity();
		OrderItem orderItem = this.currentOrder.getItem(product);

		//如果订单项不存在，则添加
		if (orderItem == null) {
			this.currentOrder.addItem(new OrderItem(product, quantity));
			stdOut.println("The product " + product.getCode()
			 + " has been added");
		} else {
			//否则修改
			orderItem.setQuantity(quantity);
			stdOut.println("The quantity of the product " +
				product.getCode() + " has been modified");
		}
	}

	/**将产品除名*/
	public void removeProduct() throws IOException {

		Product product = readProduct();
		OrderItem orderItem = this.currentOrder.getItem(product);

		if (orderItem != null) {
			this.currentOrder.removeItem(orderItem);
			stdOut.println("The product " + product.getCode()
				 + " has been removed from the current order");
		} else {
			stdErr.println(
				"There are no products in the current order with that code");
		}
	}

	/**将当前订单登记在表*/
	public void saleOrder()  {

		if (this.currentOrder.getNumberOfItems() > 0) {
			this.sales.addOrder(this.currentOrder);
			this.currentOrder = new Order();
			stdOut.println("The sale of the order has been registered");
		} else {
			//空订单我可不敢销售
			stdErr.println("The current order is empty");
		}
	}

	/**显示已售订单*/
	public void displayOrdersSold() {

		int numOrders = this.sales.getNumberOfOrders();

		if (numOrders != 0) {
			int orderNumber = 1;
			for (Order  order : this.sales) {
				stdOut.println("Order " + orderNumber++);
				for (OrderItem orderItem : order) {
					stdOut.println("   " + orderItem.toString());
				}
				stdOut.println("   Total: " +
					CURRENCY.format(order.getTotalCost()));
			}
		} else {
			stdErr.println("There are no sales");
		}
	}

	/**显示包含指定产品的订单数*/
	public void displayNumberOfOrders(Product product) {
		int count = 0;

		for (Order order : this.sales) {
			if (order.getItem(product) != null) {
				count++;
			}
		}
	}

	/**显示目录中每个产品的总销售数*/
	public void displayTotalQuantityOfProducts() {
		for (Product product : this.catalog) {
			int totalQuantity = 0;
			for (Order  order : this.sales) {
				OrderItem orderItem = order.getItem(product);
			}
		}
	}

	/**
	 * 产品代码转换器
	 * @return Product对象
	 */
	private Product readProduct() throws IOException {

		do {
			stdErr.print("Product code> ");
			stdErr.flush();
			
			Product product = this.catalog.getProduct(stdIn.readLine());
			
			if (product != null) {

				return product;
			
			} else {	
				stdErr.println("There are no products with that code");
			}
		} while (true);
	}

	/**读取产品数量*/
	private int readQuantity() throws IOException  {
		int quantity;
		do  {
			try  {
				stdErr.print("Quantity> ");
				stdErr.flush();
				quantity = Integer.parseInt(stdIn.readLine());
				if (quantity > 0) {
					return quantity;
				} else  {
					//你总得给我个正整数吧
					stdErr.println("Invalid input. Please enter a positive integer");
				}
			} catch (NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
		}  while (true);
	}
}