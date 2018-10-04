package bus;

public class MyException  extends Exception{
	
	 private static String msg = " Invlid data input " ;
	private static final long serialVersionUID = 1L;

	public MyException()
	    {
		super(msg);
	    }
	
	public MyException(String msg)	
	{
		super(msg);
	}

}
