public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        double[] x = new double[k];
		
		for(int i = 0; i<k; i++){
			x[i] = next();
		}
		
		return x;
        
    }

}