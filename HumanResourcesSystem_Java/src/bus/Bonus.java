package bus;

public class Bonus {

	private int level;
	private EnumPerformance performance;
	private double value;
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public EnumPerformance getPerformance() {
		return performance;
	}
	public void setPerformance(EnumPerformance performance) {
		this.performance = performance;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
	public Bonus()
	{
		this.level = 0;
		this.performance = EnumPerformance.excellent;
		this.value = 0.00;
	
	}
	
	public Bonus(int level , EnumPerformance performance , double value)
	{
		this.level = level;
		this.performance = performance;
		this.value = value;
		
	}
	

	public String toString()
	{
		String state;
		state = this.level + "-" + this.performance + "-" + this.value;
		return state;		
	}

	
	
	
}
