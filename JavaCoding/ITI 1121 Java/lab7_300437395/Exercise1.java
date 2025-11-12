import java.io.IOException;

public class Exercise1 {

    public static void throwException(int exceptionNumber) throws Exception{
        if(exceptionNumber==1){
            throw new Exception();
        }
        if(exceptionNumber==2){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(exceptionNumber==3){
            throw new IOException();
        }
        if(exceptionNumber==4){
            throw new IllegalArgumentException();
        }
        if(exceptionNumber==5){
            throw new NullPointerException();
        }
    }

    /*
        Returns the name of the exception thrown by the method throwException.
        Method that handles the exceptions thrown by the throwException method.
        
        @param exceptionNumber
        @return The exception name or "NoException" if no exception was caught.
     */
    public static String catchException(int exceptionNumber){
        try{
            throwException(exceptionNumber);
        }
		
        // YOUR CODE HERE
		
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("The exception type is: ArrayIndexOutOfBoundsException, the exceptionNumber is: 2");
			return "ArrayIndexOutOfBoundsException";
		}
		catch(IOException e){
			System.out.println("The exception type is: IOException, the exceptionNumber is: 3");
			return "IOException";
		}
		catch(IllegalArgumentException e){
			System.out.println("The exception type is: IllegalArgumentException, the exceptionNumber is: 4");
			return "IllegalArgumentException";
		}
		catch(NullPointerException e){
			System.out.println("The exception type is: NullPointerException, the exceptionNumber is: 4");
			return "NullPointerException";
		}
		catch(Exception e){
			System.out.println("The exception type is: Exception, the exceptionNumber is: 1");
			return "Exception";
		}
        return "NoException";
    }

    public static void main(String[] args) {
        int exceptionNumber=(int)(Math.random()*5) + 1;
        String exceptionName = catchException(exceptionNumber);
        System.out.println("Exception number: " + exceptionNumber);
        System.out.println("Exception name: " + exceptionName);
    }

}