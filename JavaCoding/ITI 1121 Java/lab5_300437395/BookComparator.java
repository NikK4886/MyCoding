import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    // Implement the comparator method for books.
	
	public int compare(Book obj1, Book obj2){
		
		int authorCompare = obj1.getAuthor().compareTo(obj2.getAuthor());
		
		int titleCompare = obj1.getTitle().compareTo(obj2.getTitle());
		
		int yearCompare = Integer.compare(obj1.getYear(),obj2.getYear());
		
		
		return (authorCompare == 0) ? ((titleCompare == 0) ? yearCompare : titleCompare) : authorCompare;
	}
}