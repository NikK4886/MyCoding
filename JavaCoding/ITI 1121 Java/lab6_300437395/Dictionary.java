public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        this.elems = new Pair[INITIAL_CAPACITY];
		this.count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
		if(this.getCount() == this.getCapacity()){
			this.increaseCapacity();
		}
		Pair temp = new Pair(key,value);
		elems[count++] = temp;
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
		Pair[] temp = new Pair[this.getCapacity() + INCREMENT];
		for(int i = 0; i<this.getCapacity(); i++){
			temp[i] = elems[i];
		}
		this.elems = temp;
    }

    @Override
    public boolean contains(String key) {
		Pair temp;
	
        for(int i = 0; i<this.getCapacity(); i++){
			if(elems[i]!= null){
				temp = elems[i];
				if(temp.getKey() == key){
					return true;
				}
			}
		}
		return false;
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
		Pair temp;
		for(int i = this.getCapacity()-1; i>=0;i--){
			if(elems[i] != null){
				temp = elems[i];
				if(temp.getKey() == key){
					return temp.getValue();
				}
			}
		}
		return null;
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
		Pair temp;
		if(this.contains(key)){
			for(int i = this.getCapacity()-1; i>=0; i--){
				if(elems[i] != null){
					temp = elems[i];
					if(temp.getKey() == key){
						temp.setValue(value);
						break;
					}
				}
			}
		}
		else{System.out.println("Key not found");}
    }

    @Override
    public Integer remove(String key) {
        /* Your code here. */
		Integer temp = this.get(key);
		this.count--;
		elems[count] = null;
		
		return temp;
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}