package bus;

public class PermanentEmployee extends Employee{
	
	private double anualSalary;
	private EnumPermJob permJob;
	private Bonus bonusRate;
	
	public double getAnualSalary()
	{
		return this.anualSalary;
	}
	
	public void setAnualSalary(double anualSalary)
	{
		this.anualSalary = anualSalary;
	}
	
	public EnumPermJob getPermJob()
	{
		return this.permJob;
	}
	
	public void setPermJob(EnumPermJob permJob)
	{
		this.permJob = permJob;
	}	
		
	public Bonus getBonusRate()
	{
		return this.bonusRate;
	}
	
	public void setBonusRate(Bonus bonusRate)
	{
		this.bonusRate = bonusRate;
	}
	
		
	public PermanentEmployee() 		
	{
		super();
		this.anualSalary = 0.00;	
		//this.contractType =  EnumContractType.fulltime;	
		this.bonusRate = null;
	}
	
	public PermanentEmployee(EnumContractType contractType, int id, String fn, String ln, String email, String telephone, String ssn, Date hiredate, Address address,
			double anualSalary, EnumPermJob permJob, Bonus bonusRate)
	{
		super(contractType, id, fn, ln, email, telephone, ssn, hiredate, address);
		
		this.anualSalary = anualSalary;
		this.permJob = permJob;
		this.bonusRate = bonusRate;
	}
	
	
	public double calculPayment()
	{
		return (this.anualSalary / 52) + ((this.anualSalary / 52) * this.bonusRate.getValue());
	}
	
}
