public class Geometric extends AbstractSeries {

    private int count = 0;
	private double num = 0;
    
    public double next() {

        num += 1.0 / Math.pow(2,count);
		count++;
		return num;

    }
}