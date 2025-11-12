import java.util.Scanner;

public class Q6{
	public static void main(String[] args){
		
		double [] grades;
		double grade, avg, med;
		int fail, pass;
		grades = new double[10];
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i<grades.length;i++){
			System.out.println("Please enter the grades");
			grade = input.nextDouble();
			grades[i] = grade;
			
		}
		
		avg = calculateAverage(grades);
		med = calculateMedian(grades);
		fail = calculateNumberFailed(grades);
		pass = calculateNumberPassed(grades);
		
		System.out.println("The average of the grades are " + avg + ".");
		System.out.println("The median of the grades are " + med + ".");
		System.out.println("The number of faillig grades are " + fail + ".");
		System.out.println("The number of passing grades are " + pass + ".");

	}

	public static double calculateAverage(double[] notes){
		double avg, totalGrade;
		avg = 0;
		totalGrade = 0;
		for(int i = 0; i<notes.length;i++){
			totalGrade = totalGrade + notes[i];
		}
		avg = totalGrade/notes.length; 
		return avg; 
	}

	public static double calculateMedian(double[] notes){
		boolean odd = true;
		if(notes.length%2 == 0){
			odd = false;
		}
		
		int i, j, argMin;
		double temp,ans;
		double[] sorted = notes;
		
		for(i = 0; i<notes.length-1;i++){
			argMin = i;
			for(j = i+1; j<notes.length; j++){
				if(notes[j]<notes[argMin]){
					argMin = j;
				}
			}
			temp = notes[argMin];
			notes[argMin] = notes[i];
			notes[i] = temp;
		}
		
		if(odd == true){
			ans = notes[(notes.length-1)/2];
		}
		else{
			ans = (notes[(notes.length/2)-1] + notes[notes.length/2])/2;
		}
		for (i = 0; i<sorted.length;i++){
			System.out.println(sorted[i]);
		}
		return ans; 
	}

	public static int calculateNumberFailed(double[] notes){
		int count = 0;
		for(int i = 0; i<notes.length; i++){
			if(notes[i] < 50.0){
				count++;
			}
		}
		return count;
	}

	public static int calculateNumberPassed(double[] notes){
		int count = 0;
		for(int i = 0; i<notes.length; i++){
			if(notes[i] >= 50.0){
				count++;
			}
		}
		return count;
	}

}