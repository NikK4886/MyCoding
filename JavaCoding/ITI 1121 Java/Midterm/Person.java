public class Person {
	Name name ;
	public Person ( Name name ) {
		this . name = name ;
	}
	public boolean equals ( Object o) {
		Person person = (Person) o;
		return(this.name.equals(person.name));
	}
}