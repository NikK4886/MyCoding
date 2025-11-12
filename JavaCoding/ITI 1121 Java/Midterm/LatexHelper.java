import java.util.Stack;

public class LatexHelper {
	public static boolean isWellBracketed ( char [ ] sequence ) {
		if ( sequence == null || sequence.length == 0) { return true ; }
		Stack <Character > stack = new Stack <Character >() ;
		// Q2 . WRITE YOUR SOLUTION ON THE ANSWERS BOOKLET
		for(char c: sequence){
			if(c == '{'){
				stack.push(c);
			}
			else if(c == '}'){
				if(stack.isEmpty()){
					return false;
				}
				else{
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		char [] x = {'{','}','}','{'};
		System.out.println(isWellBracketed(x));
	
	}

}