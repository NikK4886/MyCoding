public class Arithmetic extends AbstractSeries {

	private int count = 0;
	private double num = 0;
	
	@Override
    public double next() {
		count++;
		num += count;
		
		return num;
        
    }
	
}