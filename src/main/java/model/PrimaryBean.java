package model;

public class PrimaryBean 
{
	private String stname;
	private String mobilenumber;

	
	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	
	
	@Override
	public String toString() {
		return "DataBean [stname=" + stname + ", mobilenumber=" + mobilenumber + "]";
	}

}
