package prod;
import bus.Address;
import bus.Bonus;
import bus.Date;
import bus.Employee;
import bus.EnumContractType;
import bus.EnumPerformance;
import bus.EnumPermJob;
import bus.EnumTempJob;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import bus.PermanentEmployee;
import bus.TemporaryEmployee;
import data.FileHandler;

public class HumanResourcesV2  {	
	

	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public static ArrayList<Bonus> bonusList = new ArrayList<Bonus>();
	
	
	public static void main(String[] args) throws IOException {				
		
		// load the bonus file
		FileHandler.readBonusFile(bonusList);
		
		//The loop for choose Menu
		int option;
		do {
			showMenu();
			option = selectOption();

		} while (option != 7);
	}	
	

	public static void showMenu() {
		try { // Try catch to prevent the program from ending if there is an error
			System.out.println();
			System.out.println("*****************************************");
			System.out.println("*** Human Resources Management System ***");
			System.out.println("*****************************************");

			System.out.println("1. Add an Employee");
			System.out.println("2. Remove an Employee");
			System.out.println("3. Search an Employee");
			System.out.println("4. Generate Weekly Payroll");
			System.out.println("5. Write to File");	
			System.out.println("6. Read from File");				
			System.out.println("7. Quit");

		} catch (Exception e) {
			System.out.println("Error! " + e.getMessage());
		}
	}

	public static int selectOption() {
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println();
		System.out.print("Option: ");
		option = scanner.nextInt();
		//scanner.close();

		switch (option) {
		case 1:
			System.out.println();
			System.out.println("*** Add an Employee ***");

			addEmployee();

			break;
		case 2:
			System.out.println();
			System.out.println("*** Remove an Employee ***");

			removeEmployee();

			break;
		case 3:
			System.out.println();
			System.out.println("*** Search an Employee ***");

			searchEmployee();

			break;
		case 4:
			System.out.println();
			System.out.println("*** Generate Weekly Payroll ***");

			weeklyPayroll();

			break;
		case 5:
			System.out.println();
			System.out.println("*** Saving Employees to File ***");

			try {
				FileHandler.writeFile(employeeList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};

			break;
		case 6:
			System.out.println();
			System.out.println("*** Reading Employees from File ***");

			try {
				FileHandler.readFile(employeeList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		
			break;
		case 7:
			quit();

			break;
		default:
			System.out.println();
			System.out.println("Invalid option (choose an option between 1 and 7)");

			break;
		}
	
		return option;
		
	
	}

	/**
	 * 
	 */
	public static void addEmployee() {
		
		Scanner scan = new Scanner(System.in);

		Employee employee = null;
		
		System.out.println("Select the Contract Type: ");
		System.out.println("1. Permanent");
		System.out.println("2. Temporary");
		int option = scan.nextInt();
		
		EnumContractType contractType = null;
		EnumPermJob epj = null;
		EnumTempJob etj = null;
		EnumPerformance performance = null;
		Double anualSalary = 0.0;
		Double bonusRate = 0.0;
		Double hourlyRate = 0.0;
		Double hoursWorked = 0.0;
		Bonus bonus = null;
		
		if(option == 1) {
			contractType = EnumContractType.fulltime;

			System.out.println("Permanent Contract Detail: ");
			System.out.println("Select the Position: ");
			System.out.println("1. Manager");
			System.out.println("2. Secretary");
			System.out.println("3. Analyst");
			System.out.println("4. Programmer");			
			option = scan.nextInt();

			if (option == 1) {
				epj = EnumPermJob.manager;
			} else if (option == 2) {
				epj = EnumPermJob.secretary;
			} else if (option == 3) {
				epj = EnumPermJob.analist;
			} else if (option == 4) {
				epj = EnumPermJob.programmer;
			} else {
				System.out.println("Invalid option");
			}

			System.out.print("Enter the Anual Salary: ");
			anualSalary = scan.nextDouble();
			
			System.out.println("Enter the Employee performance: ");			
			System.out.println("1. Excellent");
			System.out.println("2. Good");
			System.out.println("3. Bad");
			option = scan.nextInt();
			
			if (option == 1 ) {					
				 performance = EnumPerformance.excellent;				
			} else if (option == 2 ) {				
				performance = EnumPerformance.good;
			} else if (option == 3) {				
				performance = EnumPerformance.bad;
			} else {
				System.out.println("Invalid performance");
			}	
			
			// search a bonus with the performance selected
			bonus = searchBonus(performance);
					
		}

		else if(option == 2) {
			contractType = EnumContractType.partime;			
		
			System.out.println("Temporary Contract Detail: ");

			System.out.println("Select the Position: ");
			System.out.println("1. Consultant");
			System.out.println("2. Intern");
			option = scan.nextInt();

			if (option == 1) {
				etj = EnumTempJob.consultant;
			} else if (option == 2) {
				etj = EnumTempJob.intern;
			} else {
				System.out.println("Invalid option");
			}
			
			System.out.print("Enter Hourly Rate: ");
			hourlyRate = scan.nextDouble();

			System.out.print("Enter Hours Worked: ");
			hoursWorked = scan.nextDouble();
			
		} else {
			System.out.println("Invalid option");
		}
		
		System.out.print("Enter the Number Id: ");
		int id = scan.nextInt();

		System.out.print("Enter the First Name: ");
		String fn = scan.next();

		System.out.print("Enter the Last Name: ");
		String ln = scan.next();

		System.out.print("Enter the e-mail: ");
		String email = scan.next();

		System.out.print("Enter the Telephone Number: ");
		String telephone = scan.next();

		System.out.print("Enter the Social Security Number: ");
		String ssn = scan.next();

		// add the address
		Address address = addressEmployee();
		
		// add the hire date
		Date date = hireDate(); //fecha de contratacion
						
		if (contractType == EnumContractType.fulltime) { // Contract type fulltime (permanent)
			employee = new PermanentEmployee(contractType, id, fn, ln, email, telephone, ssn, date, address, anualSalary, epj, bonus);
			
		} else if (contractType == EnumContractType.partime) { // Contract type parttime (temporary)
			employee = new TemporaryEmployee(contractType, id, fn, ln, email, telephone, ssn, date, address, hourlyRate, hoursWorked, etj);
						
		}		
		
		// adds the employee to the list
		employeeList.add(employee);				
		
		System.out.println("Employee added successfully");
	}

	public static Address addressEmployee() {

		Scanner scan = new Scanner(System.in);
		Address address = new Address();

		System.out.print("Enter the Street Number: ");
		int streetnumber = scan.nextInt();
		address.setstreetNumber(streetnumber);

		System.out.print("Enter the Street Name: ");
		String streetname = scan.next();
		address.setstreetName(streetname);

		System.out.print("Enter the Apartament Number: ");
		int apartnumber = scan.nextInt();
		address.setapartNumber(apartnumber);

		System.out.print("Enter the City: ");
		String city = scan.next();
		address.setcity(city);

		System.out.print("Enter the Province: ");
		String province = scan.next();
		address.setprovince(province);

		System.out.print("Enter the Postal Code: ");
		String postalcode = scan.next();
		address.setpostalCode(postalcode);

		System.out.print("Enter the Country: ");
		String country = scan.next();
		address.setcountry(country);

		return address;
		
	}

	public static void removeEmployee() {

		System.out.print("Enter the Id you want to remove: ");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		boolean exists = false;

		// search the employee in Permanent list
		for (int i = 0; i < employeeList.size(); i++) {
			Employee emp = employeeList.get(i);
			if (id == emp.getId()) {
				employeeList.remove(i);

				exists = true;
				System.out.println("Employee removed successfully");
			}
		}

		if (exists == false) {
			System.out.print("The employee doesn't exist");
		}
		
	}

	public static void searchEmployee() { //Function for Search an Employee

		System.out.print("Enter the Id you want to search: ");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		boolean exists = false;

		for (int i = 0; i < employeeList.size(); i++) {
			Employee emp = employeeList.get(i);
			if (id == emp.getId()) {
				System.out.println("-------------------------------------------------");
				System.out.println("Employee Id: " + emp.getId());
				System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
				System.out.println("Contract Type: " + emp.getContractType());
				System.out.println("Email: " + emp.getEmail());
				System.out.println("Telephone: " + emp.getTelephone());
				
				// muestra la info adicional dependiendo del tipo
				if(emp.getContractType() == EnumContractType.fulltime) {
					// converts from Employee to PermanentEmployee
					PermanentEmployee pemp = (PermanentEmployee) emp;
					
					System.out.println("Position: " + pemp.getPermJob());
					System.out.println("Anual Salary: " + pemp.getAnualSalary());
					System.out.println("Bonus Rate: " + pemp.getBonusRate().getValue());
					
				}
				else if(emp.getContractType() == EnumContractType.partime) {
					// converts from Employee to TemporaryEmployee
					TemporaryEmployee temp = (TemporaryEmployee) emp;
					
					System.out.println("Position: " + temp.getTempJob());
					System.out.println("Hourly rate: " + temp.getHourlyRate());
					System.out.println("Worked hours: " + temp.getHoursWorked());					
				}				

				exists = true;
			}
		}

		if (exists == false) {
			System.out.print("The employee doesn't exist");
		}
	
	}

	public static void weeklyPayroll() {

		for (int i = 0; i < employeeList.size(); i++) {
			Employee emp = employeeList.get(i);
			System.out.println("-------------------------------------------------");
			System.out.println("Employee Id: " + emp.getId());
			System.out.println("SSN: " + emp.getSSN()); 
			System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
			System.out.println("Payment Value: " + emp.calculPayment());
				
		}
								

	}

	public static void quit() {
		System.out.println("Bye");

		System.exit(0);
	}

	public static Date hireDate() { 

		Scanner scan = new Scanner(System.in);
		Date date = new Date();

		System.out.println("Hiredate detail: ");
		
		System.out.print("Enter the Day : ");
		int day = scan.nextInt();
		date.setDay(day);

		System.out.print("Enter the Month : ");
		int month = scan.nextInt();
		date.setMonth(month);

		System.out.print("Enter the Year : ");
		int year = scan.nextInt();
		date.setYear(year);

		return date;
		
	}

	public static Bonus searchBonus(EnumPerformance ePerformance) { //Function for Search an Bonus

		Bonus bonus = null;

		for (int i = 0; i < bonusList.size(); i++) {
			bonus = bonusList.get(i);
			if (ePerformance == bonus.getPerformance()) {
				return bonus;
			}
		}

		return bonus;
	}
	

}

