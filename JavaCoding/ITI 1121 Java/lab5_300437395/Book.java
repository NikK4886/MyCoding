public class Book {

    // Your variables declaration here
	private String author;
	private String title;
	private int year;

    public Book (String author, String title, int year) {
        this.author = author;
		this.title = title;
		this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
		return title;
    }

    public int getYear() {
        return year;
    }
	@Override
    public boolean equals(Object o) {
		boolean eq = false;
		String oAuther, tAuther, oTitle, tTitle; //o represents 'other', t represents 'this object'
		int oYear, tYear;
		Book other = (Book) o;
		

		
		try
		{
					
			oAuther = other.getAuthor();
			tAuther = author;
			oTitle = other.getTitle();
			tTitle = title;
			oYear = other.getYear();
			tYear = year;
			if(this == other){
				eq = true;
			}
			else if((oAuther.equals(tAuther)) && (oTitle.equals(tTitle)) && (oYear == tYear)){
				eq = true;
			}
			
			
		}
		catch(NullPointerException e)
		{
			if(other == null){
				return false;
			}
			oAuther = other.getAuthor();
			tAuther = author;
			oTitle = other.getTitle();
			tTitle = title;
			oYear = other.getYear();
			tYear = year;
			if(oAuther == tAuther && oTitle == tTitle){
				eq = true;
			}
			else{
				eq = false;
			}
			
		}
		return eq;
    }

    public String toString() {
        String str;
		str = author + ":" + title + "(" + year + ")";
		return str;
    }
}