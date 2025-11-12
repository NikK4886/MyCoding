public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
		 this.denominator = 1;
		 reduce();
    }

    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
		 this.denominator = denominator;
		 reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
	     int gCD, newNumerator,newDenominator, num1, num2; 
		 gCD = gcd(other.getDenominator(),denominator);
		 num1 = numerator;
		 num2 = other.getNumerator();
		 newDenominator = 0;
		
		 
		 if(gCD == 1){
			newDenominator = denominator*other.getDenominator();
		 } else if((denominator*gCD)<(other.getDenominator()*gCD)){
			newDenominator = denominator*gCD;
		 } else if((denominator*gCD)>(other.getDenominator()*gCD)){
			newDenominator = other.getDenominator()*gCD;
		 } 
		 
		
		if(gCD == 1){
			num1 = num1 * other.getDenominator();
		
		} else if(denominator != gCD){
			num1 = num1*gCD;
		
		} 
		if(gCD == 1){
			num2 = num2 * denominator;
		
		} else if(other.getDenominator() != gCD){
			num2 = num2*gCD;
			
		} 
		
		newNumerator = num1 + num2;
		Rational temp = new Rational(newNumerator,newDenominator);
		return temp;
    }

    public static Rational plus(Rational a, Rational b) {
		int gCD, num1, num2, newNumerator,newDenominator;
		gCD = a.gcd(a.getDenominator(),b.getDenominator());
		num1 = a.getNumerator();
		num2 = b.getNumerator();
		newDenominator = 0;
		
		if(gCD == 1){
			newDenominator = a.getDenominator()*b.getDenominator();
		 } else if((a.getDenominator()*gCD)<(b.getDenominator()*gCD)){
			newDenominator = a.getDenominator()*gCD;
		 } else if((a.getDenominator()*gCD)>(b.getDenominator()*gCD)){
			newDenominator = b.getDenominator()*gCD;
		 } 
		
		if(gCD == 1){
			num1 = num1 * b.getDenominator();
		
		} else if(a.getDenominator() != gCD){
			num1 = num1*gCD;
		
		} 
		if(gCD == 1){
			num2 = num2 * a.getDenominator();
		
		} else if(b.getDenominator() != gCD){
			num2 = num2*gCD;
			
		} 
		
		newNumerator = num1 + num2;
		Rational temp = new Rational(newNumerator,newDenominator);
		 
		return temp;
    }

    // Transforms this number into its reduced form

    private void reduce() {
		int gCD = gcd(numerator,denominator);
		
		if((numerator<0) && (denominator<0)){
			this.numerator = (numerator/gCD)*-1;
			this.denominator = (denominator/gCD)*-1;
		}
		else{
			this.numerator = numerator/gCD;
			this.denominator = denominator/gCD;
		}
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
		if(a<0){
			a = a * -1;
		}
		if(b<0){
			b = b * -1;
		}
			
    	
		while (a != b)
    	    if (a > b){
    		    a = a - b;
			}
    	    else{
    		    b = b - a;
			}
    	return a;
    }

    public int compareTo(Rational other) {
		int gCD, diff, num1, num2;
		num1 = numerator;
		num2 = other.getNumerator();
		reduce();
		other.reduce();
		gCD = gcd(other.getDenominator(),denominator);
		
		if(denominator != gCD){
			num1 = num1*gCD;
		}
		
		if(other.getDenominator() != gCD){
			num2 = num2*gCD;
		}
		
		
		diff = (num1-num2)/gCD;
		return diff;
    }

    public boolean equals(Rational other) {
		reduce();
		other.reduce();
		return((other.getNumerator() == numerator)&&(other.getDenominator() == denominator));
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
			result = "" + numerator; 
		   
    	} else {
    	    reduce();
			result = numerator + "/" + denominator;
    	}
    	return result;
    }

}