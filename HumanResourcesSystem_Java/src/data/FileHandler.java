package data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import bus.Address;
import bus.Bonus;
import bus.Date;
import bus.Employee;
import bus.EnumContractType;
import bus.EnumPerformance;
import bus.EnumPermJob;
import bus.EnumTempJob;
import bus.PermanentEmployee;
import bus.TemporaryEmployee;


public class FileHandler {
	
	// this function writes in employees.dat file all info in employeesArray
	public static void writeFile(ArrayList<Employee> arrayStaff) throws IOException {
		try {
			FileWriter outFile= null;
			PrintWriter writer = null;
			outFile = new FileWriter("src/data/employees.dat");
			writer = new PrintWriter(outFile);			

			for (Employee emp : arrayStaff) {

				EnumContractType contractType = emp.getContractType();
				int id = emp.getId();
				String fn = emp.getFirstName();
				String ln = emp.getLastName();
				String email = emp.getEmail();
				String telephone = emp.getTelephone();
				String ssn = emp.getSSN();
				Date hireDate = emp.getHireDate();
				Address address = emp.getAddress();

				if(contractType == EnumContractType.fulltime) {
					// cast from Employee to PermanentEmployee
					PermanentEmployee pemp = (PermanentEmployee) emp;

					double anualSalary = pemp.getAnualSalary();
					//double bonusRate = pemp.getBonusRate();
					EnumPermJob permJob = pemp.getPermJob();				
					Bonus bonus = pemp.getBonusRate();

					writer.println(
							contractType + "|" 
									+ id + "|"
									+ fn + "|"
									+ ln + "|"
									+ email + "|"
									+ telephone + "|"                    
									+ ssn + "|"                                
									+ hireDate.getDay() + "|" 	
									+ hireDate.getMonth() + "|" 	
									+ hireDate.getYear() + "|" 	
									+ address.getstreetNumber() + "|"
									+ address.getstreetName() + "|"
									+ address.getapartNumber() + "|"
									+ address.getcity() + "|"
									+ address.getpostalCode() + "|"
									+ address.getprovince() + "|"
									+ address.getcountry() + "|"
									+ anualSalary + "|" 
									+ permJob + "|"
									+ bonus.getLevel() + "|" 
									+ bonus.getPerformance().toString() + "|"
									+ bonus.getValue()
							);

				}
				else if(contractType == EnumContractType.partime) {
					// cast from Employee to PermanentEmployee
					TemporaryEmployee temp = (TemporaryEmployee) emp;

					double hourlyRate = temp.getHourlyRate();
					double hoursWorked = temp.getHoursWorked();
					EnumTempJob tempJob = temp.getTempJob();				

					writer.println(
							contractType + "|" 
									+ id + "|"
									+ fn + "|"
									+ ln + "|"
									+ email + "|"
									+ telephone + "|"                    
									+ ssn + "|"                                
									+ hireDate.getDay() + "|" 	
									+ hireDate.getMonth() + "|" 	
									+ hireDate.getYear() + "|" 	
									+ address.getstreetNumber() + "|"
									+ address.getstreetName() + "|"
									+ address.getapartNumber() + "|"
									+ address.getcity() + "|"
									+ address.getpostalCode() + "|"
									+ address.getprovince() + "|"
									+ address.getcountry() + "|"
									+ hourlyRate + "|" 
									+ hoursWorked + "|" 
									+ tempJob
							);			
				}			

			}			
			System.out.println("File writed successfully");

			writer.close();
		}
		catch (IOException e) {
			System.out.println("error writing file: " + e.getMessage());
		}
	}	

	// this function read the employees.dat file to obtain the employees info and copy that info into employeesArray
	public static void readFile(ArrayList<Employee> staffFromFile) throws IOException {
		try
		{
			FileReader inFile = new FileReader("src/data/employees.dat");		
			BufferedReader reader = new BufferedReader(inFile);

			String record;
			while((record = reader.readLine())!= null) {
				Employee employee = null;

				StringTokenizer myTokenizer = new StringTokenizer(record, "|");
				EnumContractType contractType = EnumContractType.valueOf(myTokenizer.nextToken());
				int id = Integer.parseInt(myTokenizer.nextToken());
				String fn = myTokenizer.nextToken();
				String ln = myTokenizer.nextToken();
				String email = myTokenizer.nextToken();
				String telephone = myTokenizer.nextToken();
				String ssn = myTokenizer.nextToken();

				// obtains the hire date
				int d = Integer.parseInt(myTokenizer.nextToken());
				int m = Integer.parseInt(myTokenizer.nextToken());
				int y = Integer.parseInt(myTokenizer.nextToken());
				Date date = new Date(d,m,y);

				// obtains the address;
				int streetNumber = Integer.parseInt(myTokenizer.nextToken());
				String streetName = myTokenizer.nextToken();
				int apartNumber = Integer.parseInt(myTokenizer.nextToken());
				String city = myTokenizer.nextToken();
				String postalCode = myTokenizer.nextToken();
				String province = myTokenizer.nextToken();
				String country = myTokenizer.nextToken();			
				Address address = new Address(streetNumber, streetName, apartNumber, city, province, postalCode, country);

				if(contractType == EnumContractType.fulltime) {
					double anualSalary = Double.parseDouble(myTokenizer.nextToken());
					EnumPermJob epj = EnumPermJob.valueOf(myTokenizer.nextToken());
					
					int bonusLevel = Integer.parseInt(myTokenizer.nextToken());
					EnumPerformance ePerformance = EnumPerformance.valueOf(myTokenizer.nextToken());
					double bonusValue = Double.parseDouble(myTokenizer.nextToken());
					
					Bonus bonusRate = new Bonus(bonusLevel, ePerformance, bonusValue);
					
					employee = new PermanentEmployee(contractType, id, fn, ln, email, telephone, ssn, date, address, anualSalary, epj, bonusRate);

					// adds the employee to the arrayList
					staffFromFile.add(employee);

				}else if(contractType == EnumContractType.partime) {
					double hourlyRate = Double.parseDouble(myTokenizer.nextToken());
					double hoursWorked = Double.parseDouble(myTokenizer.nextToken());
					EnumTempJob etj = EnumTempJob.valueOf(myTokenizer.nextToken());

					employee = new TemporaryEmployee(contractType, id, fn, ln, email, telephone, ssn, date, address, hourlyRate, hoursWorked, etj);

					// adds the employee to the arrayList
					staffFromFile.add(employee);

				}
				else {
					System.out.println("Invalid value for contract type field");
				}

			}
			System.out.println("File readed successfully");

			reader.close();		
		}
		catch (IOException ex)
		{
			System.out.println("........File not FOUND....");
		}	 

	} 

	
	// This function reads the Performance.txt file and copy that info into bonusArray 
	public static void readBonusFile(ArrayList<Bonus> staffFromFile) throws IOException {
		try
		{
			FileReader inFile = new FileReader("src/data/Performance.txt");		
			BufferedReader reader = new BufferedReader(inFile);

			String record;
			while((record = reader.readLine())!= null) {
				Bonus bonus = null;

				StringTokenizer myTokenizer = new StringTokenizer(record, "|");
				int bonusLevel = Integer.parseInt(myTokenizer.nextToken());
				EnumPerformance ePerformance = EnumPerformance.valueOf(myTokenizer.nextToken());
				double bonusValue = Double.parseDouble(myTokenizer.nextToken());
				
				bonus = new Bonus(bonusLevel, ePerformance, bonusValue);
				
				// adds the bonus to the arrayList
				staffFromFile.add(bonus);

			}
			System.out.println("File readed successfully");

			reader.close();		
		}
		catch (IOException ex)
		{
			System.out.println("........File not FOUND....");
		}	 

	} 
}

