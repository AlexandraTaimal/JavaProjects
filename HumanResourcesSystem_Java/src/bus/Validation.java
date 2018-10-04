package bus;
import java.util.regex.Pattern;

public class Validation {
//1--- Validate Id
	public static void validID(int id)throws MyException{
		//if(!(Pattern.matches("[0-9]", Integer.toString(id)))){throw new MyException("Please enter a digit");}
		if(id < 1000 || id > 9999  ) {
			       throw new MyException("Please enter a 4 digit number");
		 }
	}
//2-- Validate Alphabet Letters
	public static void validName(String string) throws MyException{
		if(!(Pattern.matches("^[A-Za-z]+$", string))){throw new MyException("Please enter only alphabet letter");}
	}
//3-- Validate Postal Code
	public static void validPostalCode(String postalCode) throws MyException{
		if(!(Pattern.matches("[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]", postalCode))){throw new MyException("Please enter postalcode as following : H7L2L8");}
	}
//4-- Validate SSN
	public static void validSsn(String ssn) throws MyException{
		if(!(Pattern.matches("[0-9][0-9][0-9]+-[0-9][0-9][0-9]+-[0-9][0-9][0-9]", ssn)))
		throw new MyException("Please enter ssn as : 111-111-111");}
//5-- Validate Email
		public static void validEmail(String email)throws MyException{		
			if(!(Pattern.matches("^\\w+@[a-zA-z]+.[a-zA-Z]{2,3}$",email))){throw new MyException("Please enter a valid email");}
		}
		
//6-- Validate Telephone
		public static void validTelephone(String ssn) throws MyException{
			if(!(Pattern.matches("[0-9][0-9][0-9]+-[0-9][0-9][0-9]+-[0-9][0-9][0-9][0-9]", ssn)))
			throw new MyException("Please enter Telephone as : 430-832-2077");
		}			
		
//7-- Validate Positive numbers
	public static void negativeNumberException(int num)throws MyException{
		if(num < 0){
			     throw new MyException("Please enter a positive number");  }		
	 }	
//8-- Validate range
	public static void betweenZeroAndNine(int num)throws MyException {		
		if (num < 0 || num > 9){throw new MyException("Please enter a number between 0 and 9");}
	}
}
/**
 * You can add more validation methods
 */

