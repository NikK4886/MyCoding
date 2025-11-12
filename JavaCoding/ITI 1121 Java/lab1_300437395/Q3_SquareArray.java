public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int [] array;
		array = new int[size];
		
		for(int i = 0; i <= array.length-1;i++){
				array[i] = i*i;
		}	
		
		return array;
	}

	public static void main(String[] args){
		int [] squaredArray = createArray(12);
		
		for(int i = 0; i<=squaredArray.length-1;i++){
			System.out.println("value for index 0 is " + squaredArray[i]);
			
		}
		
	}
}