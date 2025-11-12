import java.util.ArrayList;
import java.util.*;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        this.library.add(b);
    }

    public void sort() {
        Collections.sort(library, new BookComparator());
    }


    public void printLibrary() {
        System.out.println(library);
    }
}


 
