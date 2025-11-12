public class ITIStringBuffer {

	private SinglyLinkedList<char []> list; 

    public ITIStringBuffer() {
        this.list = new SinglyLinkedList<char []>();
    }

    public ITIStringBuffer(String firstString){
		char [] arry = firstString.toCharArray();
        this.list = new SinglyLinkedList<char []>();
		
		if(list.isEmpty()){
			list.addFirst(arry);
		}
		else{
			list.add(arry);
		}
		
    }

    public void append(String nextString){
        
		char [] arry = nextString.toCharArray();
		
		if(list.isEmpty()){
			list.addFirst(arry);
		}
		else{
			list.add(arry);
		}
	
		
    }

    public String toString(){
		int size = list.size();
		int size1 = 0; 
		for(char [] c : list){
			size1 = size1+c.length;
		}
		
		char [] arry = new char[size1];
		int j = 0;
		for(char[] s : list){
			for(int i = 0; i<s.length; i++){
				arry[j] = s[i];
				j++;
			}
		}
		String out = new String(arry);
		return out;
	}

}
