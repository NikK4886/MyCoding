public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {

		this.combination = combination;
		this.open = false;
		this.activated = true; 
		this.numberOfAttempts = 0;
    }

    // Access methods.

    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {

        // Put your code here, then remove the line below.
	
		if(activated != false){
			if(this.combination == combination){
				open = true;
			}
			else{numberOfAttempts = numberOfAttempts+1;}
		}
		if(numberOfAttempts > 0 && numberOfAttempts == MAX_NUMBER_OF_ATTEMPTS){
			activated = false;
			numberOfAttempts = 0;
			open = false;
			return open;
		}
        return open;
    }

    public void activate( Combination c ) {
        if(c == combination){
			activated = true;
		} 
    }
}