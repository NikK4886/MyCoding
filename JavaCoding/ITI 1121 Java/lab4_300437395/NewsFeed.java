/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size = 0;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	this.messages = new Post[MAX_SIZE];
    }

    public void add(Post message) {
      for(int i = 0; i<MAX_SIZE; i++){
		  if(messages[i] == null){
			  this.messages[i] = message;
			  this.size ++;
			  break;
		  }
	  }
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		NewsFeed newPostFeed;
		newPostFeed = new NewsFeed();
		for(Post post : messages){
			if(post instanceof PhotoPost){
				newPostFeed.add(post);
			}
		}
		return newPostFeed;
		
		
  	}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed newPlusFeed, bigFeed, smallFeed;
		newPlusFeed = new NewsFeed();
		bigFeed = new NewsFeed();
		smallFeed = new NewsFeed();
		sort();
		other.sort();
		int big,small,counter;
		counter = 0;
	
		
		if(size>other.size){
			big = size;
			small = other.size;
			for(int i = 0; i<MAX_SIZE;i++){
				bigFeed.add(messages[i]);
			}
			
			smallFeed = other;
		}
		else if(size<other.size){
			big = other.size;
			small = size;
			bigFeed = other;
			for(int i = 0; i<MAX_SIZE;i++){
				smallFeed.add(messages[i]);
			}
		}
		else{
			big = size;
			small = size;
			for(int i = 0; i<MAX_SIZE;i++){
				bigFeed.add(messages[i]);
			}
			
			smallFeed = other;
		}
		
		for(int i =0; i<MAX_SIZE;i++){
			if((bigFeed.get(i) == null) && (counter < small)){
				newPlusFeed.add(smallFeed.get(counter));
				counter++;
			}
			else if(bigFeed.get(i) != null){
				for(int j=0;j<small;j++){
					if(bigFeed.get(i).compareTo(smallFeed.get(j))>0){
						newPlusFeed.add(bigFeed.get(i));
						break;
					}
					else{
						newPlusFeed.add(smallFeed.get(j));
					}
				}
			}
		}
		
		
		return newPlusFeed;
  	}

}
