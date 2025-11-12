public class Iterative {

	public static BitList complement( BitList in ) {
		String input = in.toString();
		char [] binary = input.toCharArray();
		
		for(int i = 0; i<binary.length; i++){
			if(binary[i] == '0'){
				binary[i] = '1';
			}
			else if(binary[i] == '1'){
				binary[i] = '0';
			}
		} 
		
		String output = String.valueOf(binary);
		
		BitList out = new BitList(output);
		
		return out;
		
	}

	public static BitList or( BitList a, BitList b ) {
		
		
		
		char [] binary1 = a.toString().toCharArray();
		char [] binary2 = b.toString().toCharArray();
		char [] binary3 = new char[binary1.length];
		
		if(binary1.length != binary2.length){
			throw new IllegalArgumentException();
		}
		else if((a.toString() == "") || (b.toString() == "")){
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i<binary1.length; i++){
			if((binary1[i] == '1')||(binary2[i] == '1')){
				binary3[i] = '1';
			}
			else{
				binary3[i] = '0';
			}
		}
		
		BitList out = new BitList(String.valueOf(binary3));
		
		return out;
		
		
	}

	public static BitList and( BitList a, BitList b ) {

		char [] binary1 = a.toString().toCharArray();
		char [] binary2 = b.toString().toCharArray();
		char [] binary3 = new char[binary1.length];
		
		if(binary1.length != binary2.length){
			throw new IllegalArgumentException();
		}
		else if((a.toString() == "") || (b.toString() == "")){
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i<binary1.length; i++){
			if((binary1[i] == '1')&&(binary2[i] == '1')){
				binary3[i] = '1';
			}
			else{
				binary3[i] = '0';
			}
		}
		
		BitList out = new BitList(String.valueOf(binary3));
		
		return out;
	}

	public static BitList xor( BitList a, BitList b ) {

		char [] binary1 = a.toString().toCharArray();
		char [] binary2 = b.toString().toCharArray();
		char [] binary3 = new char[binary1.length];
		
		if(binary1.length != binary2.length){
			throw new IllegalArgumentException();
		}
		else if((a.toString() == "") || (b.toString() == "")){
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i<binary1.length; i++){
			if(binary1[i] == binary2[i]){
				binary3[i] = '0';
			}
			else{
				binary3[i] = '1';
			}
		}
		
		BitList out = new BitList(String.valueOf(binary3));
		
		return out;
	}
}