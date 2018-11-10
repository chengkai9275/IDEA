package ck.mybatis.po;

/**
 * 订单自定义po，包括订单信息、用户信息
 * 
 * @author Thinkpad
 * 
 */
public class OrdersCustom extends Orders {

	private String username;// 用户名称
	private String address;// 用户地址
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}
