package bus;

public class Date {


	private int day;
	private int month;
	private int year;
	
	
	public int getDay()
	{
		return this.day;
	}
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public int getMonth()
	{
		return this.day;
	}
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getYear()
	{
		return this.year;
	}
	public void setYear(int year)
	{
		 this.year = year;
	}
	
	public Date()
	{
		super();
		this.day = 00;
		this.month = 00;
		this.year = 0000;		
	}
	public Date (int day, int month, int year)
	{
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		
	}
	public String toString()
	{
		return this.day + "-" +  this.month + "-" + this.year;
	}


	

}

	
	
	

