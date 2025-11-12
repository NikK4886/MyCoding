public class Name {
	public String firstName;
	public String lastName;
	
	public Name (String firstName, String lastName ) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public boolean equals (Object o) {
		
		Name name = (Name) o;  
		if(o == null){
			return false;
		}
		
		if((this.firstName == name.firstName) && (this.lastName == name.lastName)){
			return true;
		}
		return false;
	}
}