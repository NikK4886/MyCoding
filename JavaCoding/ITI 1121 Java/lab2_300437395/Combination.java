public class Combination {

    // Instance variables.
    private int firstNum, secondNum, thirdNum; 
	private String combo; 

    // Constructor
    public Combination( int first, int second, int third ) {
        this.firstNum = first;
		this.secondNum = second;
		this.thirdNum = third; 
    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals(Object other ) {
		
		if(this == other){ 
			return true;
		}
		if(other == null || getClass() != other.getClass()){
			return false;
		}
		Combination combination = (Combination) other;
		return (firstNum == combination.firstNum && secondNum == combination.secondNum && thirdNum == combination.thirdNum);
		
    }

    // Returns a String representation of this Combination.

    public String toString() {
        combo = firstNum + ":" + secondNum + ":" + thirdNum; 
        return combo;
    }
}
