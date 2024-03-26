package model;

public class SecondaryBean 
{

	private String mobilenumber;
	private String address;
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SecondaryBean [mobilenumber=" + mobilenumber + ", address=" + address + "]";
	}
	
}
