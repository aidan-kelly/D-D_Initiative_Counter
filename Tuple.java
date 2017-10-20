package initCounter;
public class Tuple implements Comparable{

	//variables for left and right values
	private final Integer left;
	private final String right;
	
	//constructor of the tuple
	public Tuple(Integer left, String right){
		this.left = left;
		this.right = right;
	}
	
	//returns the value of L
	public Integer getL(){
		return left;
	}
	
	//returns value of R
	public String getR(){
		return right;
	}

	//allows us to compare 2 Tuple objects
	public int compareTo(Object t) {
		
		//sets an int = passed in L
		int compareL=((Tuple)t).getL();
		
		//allows for sorting is descending order
		return compareL-this.getL();		
	}
	
	//returns a string containing info about the Tuple
	public String toString(){
		return this.getR() +" " + this.getL();
		
	}
	
}
