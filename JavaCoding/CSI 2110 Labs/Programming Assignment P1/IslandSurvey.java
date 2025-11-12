import java.io.*;
import java.util.*;


public class IslandSurvey<E>{
	
	public static final class Data{
		
		public final int rows, cols, phaseCount;
		public final char[][] grid;
		public final int [] phaseIndex;
		public final int [][] phaseI;
		public final int [][] phaseJ;
		
		Data(int rows, int cols, int phaseCount, char[][] grid, int[] phaseIndex, int[][] phaseI, int[][] phaseJ){
			
			this.rows = rows;
			this.cols = cols;
			this.phaseCount = phaseCount;
			this.grid = grid;
			this.phaseIndex = phaseIndex;
			this.phaseI = phaseI;
			this.phaseJ = phaseJ;
		}	
	}

	public static final class Reader{
		
		private final BufferedReader br;
		private String[] parts = new String[0];
		private int index = 0;
		
		Reader(BufferedReader br){
			this.br = br;
		}
		
		String nextStr() throws IOException{
			
			while(index >= parts.length){
				String line = br.readLine();
				
				if(line == null){return null;}
				
				line = line.trim();
				
				if(line.isEmpty()){continue;}
				
				parts = line.split("\\s+");
				index = 0;
			}
			
			return(parts[index++]);
		}
		
		Integer nextInt() throws IOException{
			
			String s = nextStr();
			if(s == null){return null;}
			return Integer.parseInt(s);
		}
	}
	
	public Data read(BufferedReader br) throws IOException{
		
		Reader rd = new Reader(br);
		Integer S = rd.nextInt();
		Integer T = rd.nextInt();
		if(S == null || T == null){throw new IllegalArgumentException("T or S is invalid or missing");}
		
		char[][] grid = new char[S][T];
		
		for(int i = 0; i<S; i++){
			String row = rd.nextStr();
			if(row == null){throw new IllegalArgumentException("Row returns null at row " + i);}
			
			if(row.length() != T){throw new IllegalArgumentException("Row " + i + " length less then expected length of T = " + T);}
			
			for(int j = 0; j<T; j++){
				char c = row.charAt(j);
				if(c != '0' && c!= '1'){throw new IllegalArgumentException("Data at Row: "+ i + " Colum: "+ j +", is not valid data");}
				
				grid[i][j] = c;
				
			}
			
		}
		
		Integer PhaseNum = rd.nextInt();
		if(PhaseNum == null){throw new IllegalArgumentException("Invalid or missing data for phases");}
		
		int phaseCount = PhaseNum;
		
		int [] phaseIndex = new int[phaseCount];
		int [][] phaseI = new int [phaseCount][];
		int [][] phaseJ = new int [phaseCount][];
		
		for(int pNum = 0; pNum<phaseCount; pNum++){
			Integer numOfCells = rd.nextInt();
			if(numOfCells == null){throw new IllegalArgumentException("Missing number of cells for phase "+pNum);}
			
			phaseIndex[pNum] = numOfCells;
			phaseI[pNum] = new int [numOfCells];
			phaseJ[pNum] = new int [numOfCells];
			
			for(int pChange = 0; pChange<numOfCells; pChange++){
				Integer pI = rd.nextInt();
				Integer pJ = rd.nextInt();
				if(pI == null || pJ == null){throw new IllegalArgumentException("Expected two numbers: phase: "+pNum+", change: "+pChange);}
				
				if(pI >= S || pI < 0 || pJ >= T || pJ < 0){throw new IllegalArgumentException("Phase change out of range: phase: "+pNum+", change: "+pChange);}
				
				phaseI[pNum][pChange] = pI;
				phaseJ[pNum][pChange] = pJ;	
			} 
		}
		return new Data(S, T, phaseCount, grid, phaseIndex, phaseI, phaseJ);
	}
		
	public Data applyPhase(Data d, int phaseNum) {
		if(phaseNum >= d.phaseIndex.length){throw new IllegalArgumentException("Phase number: "+phaseNum+" does not exist for this data");}
			
		for (int i = 0; i < d.phaseIndex[phaseNum]; i++) {
			d.grid[d.phaseI[phaseNum][i]][d.phaseJ[phaseNum][i]] = '1';
		}
		return d;
	}
	
	public static class ClusterGrid<E>{
		Node<E>[][] grid;
		
		ClusterGrid(int row, int col){
			this.grid = (Node<E>[][]) new Node[row][col];
		}
		
		int rows(){return grid.length;}
		
		int cols(){return grid[0].length;}
		
		Node<E> get(int i, int j){return grid[i][j];}
		
		void set(int i, int j, Node<E> pC){grid[i][j] = pC;}
	}
	
	public static class Pos{
		int i;
		int j;
		
		Pos(int i, int j){
			this.i = i;
			this.j = j;
		}
		
	}

	public static ClusterGrid clusterGrid;
	public static Partition BP = new Partition<>();
	public static int num = 0;
	
	private boolean inBounds(int r, int c, int rows, int cols) {
		return r >= 0 && r < rows && c >= 0 && c < cols;
	}
	
	private boolean isActive(Node<E> n) {
		return n != null && n.getElement() != null && n.getCluster() != null;
	}
	
	private void check(int i, int j, int rows, int cols) {
		Node<E> cur = clusterGrid.get(i, j);
		if (!isActive(cur)) return; 
	
		if (inBounds(i - 1, j, rows, cols)) {
			Node<E> up = clusterGrid.get(i - 1, j);
			if (isActive(up) && BP.find(cur) != BP.find(up)) {
				BP.union(cur, up);
			}
		}

		if (inBounds(i, j - 1, rows, cols)) {
			Node<E> left = clusterGrid.get(i, j - 1);
			if (isActive(left) && BP.find(cur) != BP.find(left)) {
				BP.union(cur, left);
			}
		}

		if (inBounds(i, j + 1, rows, cols)) {
			Node<E> right = clusterGrid.get(i, j + 1);
			if (isActive(right) && BP.find(cur) != BP.find(right)) {
				BP.union(cur, right);
			}
		}

		if (inBounds(i + 1, j, rows, cols)) {
			Node<E> down = clusterGrid.get(i + 1, j);
			if (isActive(down) && BP.find(cur) != BP.find(down)) {
				BP.union(cur, down);
			}
		}
	}

	
	public void InitGrid(Data d){
		if(clusterGrid == null){
			clusterGrid = new ClusterGrid(d.rows,d.cols);
		}
		for(int i = 0; i<d.rows; i++){
			for(int j = 0; j<d.cols; j++){
				if(d.grid[i][j] == '1'){
					Pos pos = new Pos(i,j);
					Node p = BP.makeCluster((E)pos);
					clusterGrid.set(i,j,p);
				}
			}
		}
		Node temp1;
		Node temp2;
		for(int x = 0; x<d.rows; x++){
			for(int y = 0; y<d.cols; y++){
				temp1 = clusterGrid.get(x,y);
				if(temp1 == null){continue;}
				
				else{check(x,y,d.rows,d.cols);}
			}
		}
	}
	
	public void UpdateGrid(Data d){
		
		Data data = applyPhase(d,num);
		num++;
		
		
		clusterGrid = new ClusterGrid(d.rows,d.cols);
		BP = new Partition<>();
		

		
		for(int i = 0; i<data.rows; i++){
			for(int j = 0; j<data.cols; j++){
				if(data.grid[i][j] != '1'){continue;}
				
				Pos pos = new Pos(i,j);
				Node p = BP.makeCluster((E)pos);
				clusterGrid.set(i,j,p);
			}
		}
		Node temp1;
		Node temp2;
		for(int x = 0; x<d.rows; x++){
			for(int y = 0; y<d.cols; y++){
				temp1 = clusterGrid.get(x,y);
				if(temp1 == null){continue;}
				
				else{check(x,y, d.rows, d.cols);}
				
			}
		}
	}
	
	public int NumOfIsland(){
		if(clusterGrid == null){throw new IllegalArgumentException("Cluster Grid has not been initalized");}
		int tempNum = BP.numberOfClusters();
		return tempNum;
	}
	
	public int[] ListNumOfIsland(){
		if(clusterGrid == null){throw new IllegalArgumentException("Cluster Grid has not been initalized");}
		int [] intArray = BP.clusterSizes();
		int[] temp = {-1};
		if(intArray.length == 0){return temp;}
		Integer [] tempArry = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			tempArry[i] = Integer.valueOf(intArray[i]);
		}
		Arrays.sort(tempArry, Collections.reverseOrder());
		
		for (int i = 0; i < tempArry.length; i++) {
			intArray[i] = tempArry[i];
		}
		return intArray;
	}
	
	public int TotalArea(){
		if(clusterGrid == null){throw new IllegalArgumentException("Cluster Grid has not been initalized");}
		int[] tempArry = BP.clusterSizes();
		int tempNum = 0;
		
		for(int num : tempArry){
			tempNum = tempNum + num;
		}
		return tempNum;
	}
	public static void main(String[] args) throws Exception {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))
        ) {
			IslandSurvey<String> survey = new IslandSurvey<>();
            Data data = survey.read(br);
			int count = data.phaseCount;
			survey.InitGrid(data);
			int nums = survey.NumOfIsland();
			int [] listIsland = survey.ListNumOfIsland();
			int area = survey.TotalArea();
			
			out.print(nums);
			out.print("\n");
			out.print(Arrays.toString(listIsland));
			out.print("\n");
			out.print(area);
			out.print("\n");
			out.print("\n");
			
			for(int i = 0; i<count; i++){
				survey.UpdateGrid(data);
				nums = survey.NumOfIsland();
				listIsland = survey.ListNumOfIsland();
				area = survey.TotalArea();
				
				out.print(nums);
				out.print("\n");
				out.print(Arrays.toString(listIsland));
				out.print("\n");
				out.print(area);
				out.print("\n");
				out.print("\n");
			}
			
			
            out.flush();
        }
    }
}