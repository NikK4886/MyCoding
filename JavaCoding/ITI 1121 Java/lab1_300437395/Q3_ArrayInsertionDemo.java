public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int [] returnArray;
		returnArray = new int[beforeArray.length + 1];
		
		for(int i = 0; i<returnArray.length;i++){
			if(i == indexToInsert){
				returnArray[i] = valueToInsert;
			} 
			else if(i>indexToInsert)
			{
				returnArray[i] = beforeArray[i-1];
			}
			else{returnArray[i] = beforeArray[i];}
			
		}
		return returnArray;
	}

	public static void main(String[] args){
		int [] beforeArray, afterArray;
		beforeArray = new int [] {1,5,4,7,9,6};
		int num, index;
		num = 15;
		index = 3;
		afterArray = insertIntoArray(beforeArray, index,num); 
		
		for(int i = 0; i<beforeArray.length; i++){
			System.out.println(beforeArray[i]);
		}
		for(int i = 0; i<afterArray.length; i++){
			System.out.println(afterArray[i]);
		}
		
	}
}