package bus;

public class TemporaryEmployee extends Employee {

	private double hourlyRate;
	private double hoursWorked;
	private EnumTempJob tempJob;
	//private EnumContractType contractType = EnumContractType.partime;
	
	
	public double getHourlyRate()
	{
		return this.hourlyRate;
	}
	
	public void setHourlyRate (double hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}
	
	public double getHoursWorked()
	{
		return this.hoursWorked;
	}
	
	public void setHoursWorked (double hoursWorked)
	{
		this.hoursWorked = hoursWorked;
	}	
	
	public void setTempJob(EnumTempJob tempJob)
	{
		this.tempJob = tempJob;
	}
	
	public EnumTempJob getTempJob()
	{
		return this.tempJob;
	}
	
/*	public EnumContractType getContractType()
	{
		return this.contractType;
	}	*/
	
	
	public TemporaryEmployee() 		
	{
		super(); 
		this.hourlyRate =  0.00;
		this.hoursWorked = 0.00;
				
	}
	
	public TemporaryEmployee (EnumContractType contractType, int id, String fn, String ln, String email, String telephone, String ssn, Date hiredate, Address address,
			double hourlyRate, double hoursWorked, EnumTempJob tempJob)
	{
		super(contractType, id, fn, ln, email, telephone, ssn, hiredate, address);
		
		this.tempJob = tempJob;
		this.hourlyRate =  hourlyRate;
		this.hoursWorked = hoursWorked;

	}

	@Override
	public double calculPayment() {
		// TODO Auto-generated method stub
		return this.hourlyRate * this.hoursWorked;
	}

	
}
