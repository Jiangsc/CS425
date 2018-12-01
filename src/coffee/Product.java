package coffee;

public class Product {
	public String productname;
	public String price;
	public int stock;
	public int sale;
	public int productid;
	
	public Product(String productname, String price, int stock, int sale, int productid) {
		super();
		this.productname = productname;
		this.price = price;
		this.stock = stock;
		this.sale = sale;
		this.productid = productid;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}

	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the sale
	 */
	public int getSale() {
		return sale;
	}

	/**
	 * @param sale the sale to set
	 */
	public void setSale(int sale) {
		this.sale = sale;
	}

	/**
	 * @return the productid
	 */
	public int getProductid() {
		return productid;
	}

	/**
	 * @param productid the productid to set
	 */
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	

}
