package bus;

import java.io.Serializable;

public abstract class Employee implements IPayable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1426713266456490384L;
	/**
	 * 
	 */	
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String ssn;
	private Date hireDate;
	private Address address;	
	private EnumContractType contractType;
	

	public EnumContractType getContractType() {
		return contractType;
	}
	public void setContractType(EnumContractType contractType) {
		this.contractType = contractType;
	}
			
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id) throws MyException {
		Validation.validID(id);
	
		this.id = id;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setFirstName(String fn)throws MyException{
		Validation.validName(fn);
		this.firstName = fn;
	}		
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public void setLastName(String ln)throws MyException{
		Validation.validName(ln);
		this.lastName = ln;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)throws MyException{
		Validation.validEmail(email);
		this.email = email;		
	}
	
	public String getTelephone()
	{
		return this.telephone;
	}
	
	public void setTelephone(String telephone)throws MyException{	
		Validation.validTelephone(telephone);
		this.telephone = telephone;		
	}		
	
	public String getSSN()
	{
		return this.ssn;
	}
	
	public void setSSN(String ssn)throws MyException{	
		Validation.validSsn(ssn);
		this.ssn = ssn;
	}
	
	public Date getHireDate()
	{
		return this.hireDate;
	}
	
	public void setHireDate(Date hireDate )
	{
		this.hireDate = hireDate;
	}
	
	public Address getAddress()
	{
		return this.address;
	}
	
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	//constructor
	public Employee()
	{
		this.id = 0000;
		this.firstName = "undefined";
		this.lastName = "undefined";
		this.email = " ";
		this.telephone = "000-0000000";
		this.ssn = "undefined";	
		this.hireDate = new Date();
		this.address = new Address();		
	}
	
	public Employee(EnumContractType contractType, int id, String fn, String ln, String email, String telephone, String ssn, Date hireDate, Address address)
	{
		this.contractType = contractType;
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.email = email;
		this.telephone = telephone;
		this.ssn = ssn;	
		this.hireDate = hireDate;
		this.address = address;							
	}
	
	public String toString()
	{
		String state;
		state = this.contractType + " - " + this.id + " - " + this.firstName + " -" + this.lastName + " - "+
			    this.email + " - " + this.telephone + " - " + this.ssn + " - " +
				this.hireDate + " - " + this.address  ;
				
		return state;
	}
	
	@Override
	public double calculPayment() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

	


