package coffee;

public class Customer {
	public String c_firstname;
	public String c_lastname;
	public String address;
	public int tot_points;
	public int ava_points;
	public int customerid;
	
	public Customer(String c_firstname, String c_lastname, String address, int tot_points, int ava_points,
			int customerid) {
		super();
		this.c_firstname = c_firstname;
		this.c_lastname = c_lastname;
		this.address = address;
		this.tot_points = tot_points;
		this.ava_points = ava_points;
		this.customerid = customerid;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the c_firstname
	 */
	public String getC_firstname() {
		return c_firstname;
	}

	/**
	 * @param c_firstname the c_firstname to set
	 */
	public void setC_firstname(String c_firstname) {
		this.c_firstname = c_firstname;
	}

	/**
	 * @return the c_lastname
	 */
	public String getC_lastname() {
		return c_lastname;
	}

	/**
	 * @param c_lastname the c_lastname to set
	 */
	public void setC_lastname(String c_lastname) {
		this.c_lastname = c_lastname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the tot_points
	 */
	public int getTot_points() {
		return tot_points;
	}

	/**
	 * @param tot_points the tot_points to set
	 */
	public void setTot_points(int tot_points) {
		this.tot_points = tot_points;
	}

	/**
	 * @return the ava_points
	 */
	public int getAva_points() {
		return ava_points;
	}

	/**
	 * @param ava_points the ava_points to set
	 */
	public void setAva_points(int ava_points) {
		this.ava_points = ava_points;
	}

	/**
	 * @return the customerid
	 */
	public int getCustomerid() {
		return customerid;
	}

	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	

}
