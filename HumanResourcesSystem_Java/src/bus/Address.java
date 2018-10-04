package bus;

public class Address 
{
	private int streetNumber;
	private String streetName;
	private int apartNumber;
	private String city;
	private String province;
	private String postalCode;
	private String country;
	
	
	public int getstreetNumber()
	{
		return this.streetNumber ;		
	}
	public void setstreetNumber(int streetNumber)
	{
		this.streetNumber = streetNumber ;
	}
	public String getstreetName()
	{
		return this.streetName ;		
	}
	public void setstreetName(String streetName)
	{
		this.streetName = streetName ;
	}
	public int getapartNumber()
	{
		return this.apartNumber ;		
	}
	public void setapartNumber(int apartNumber)
	{
		this.apartNumber = apartNumber;
	}
	public String getcity()
	{
		return this.city ;		
	}
	public void setcity(String city)
	{
		this.city = city ;
	}
	public String getprovince()
	{
		return this.province ;		
	}
	public void setprovince(String province)
	{
		this.province = province;
	}
	public String getpostalCode()
	{
		return this.postalCode;		
	}
	public void setpostalCode(String postalCode)
	{
		this.province = postalCode;
	}
	public String getcountry()
	{
		return this.country;		
	}
	public void setcountry(String country)
	{
		this.country = country;
	}
	
	public Address()
	{
		this.streetNumber = 0000;
		this.streetName = "unknown";
		this.apartNumber = 0000;
		this.city = "unknown";
		this.province = "unknown";
		this.postalCode = "unknown";
		this.country = "unknown";
		
		
	}
	public Address(int streetNumber, String streetName, int apartNumber, String city,
			String province, String postalCode,  String country)
	{		
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.apartNumber = apartNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	
	
	public String toString()
	{
		String state;
		state = this.streetNumber + "-" + this.streetName + "-" + this.apartNumber + 
				"-" + this.city + "-" + this.province + "-" + this.postalCode + "-" + this.country;
		return state;		
	}

	
	

}
