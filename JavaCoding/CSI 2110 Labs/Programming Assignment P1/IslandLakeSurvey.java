import java.io.*;
import java.util.*;

public class IslandLakeSurvey {

    static final int[] DR4 = { -1, 1, 0, 0 };
    static final int[] DC4 = { 0, 0, -1, 1 };
    static final int[] DR8 = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static final int[] DC8 = { -1,  0,  1, -1, 1, -1, 0, 1 };

    static final class FS {
        BufferedReader br;
        StringTokenizer st;
        FS(Reader r) { br = new BufferedReader(r); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        Integer nextInt() throws IOException {
            String s = next();
            return s == null ? null : Integer.parseInt(s);
        }
    }

    static final class Res {
        int islands;
        int lakes;
        int totalIslandArea;
        int totalLakeArea;
        int[] sizes;
    }

    static final class Pos {
        final int i, j;
        Pos(int i, int j) { this.i = i; this.j = j; }
        public String toString() { return i + "," + j; }
    }

   @SuppressWarnings("unchecked")
	static Node<Pos>[][] makeNodes(char[][] grid, Partition<Pos> BP) {
		int rows = grid.length, cols = grid[0].length;
		Node<Pos>[][] clusterGrid = (Node<Pos>[][]) new Node[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				char ch = grid[r][c];
				if (ch != '0' && ch != '1') throw new IllegalArgumentException("Invalid char at (" + r + "," + c + "): " + ch);
				if (ch == '1') {
					clusterGrid[r][c] = BP.makeCluster(new Pos(r, c));   // <-- change to pass Pos and use returned Node
				}
			}
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (clusterGrid[r][c] == null) continue;
				if (r > 0 && clusterGrid[r - 1][c] != null) BP.union(clusterGrid[r][c], clusterGrid[r - 1][c]);
				if (c > 0 && clusterGrid[r][c - 1] != null) BP.union(clusterGrid[r][c], clusterGrid[r][c - 1]);
			}
		}
		return clusterGrid;
	}


    static Res Survey(char[][] grid, Node<Pos>[][] clusterGrid, Partition<Pos> BP) {
        int rows = grid.length, cols = grid[0].length;

        HashMap<Node<Pos>, Integer> areaByRep = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Node<Pos> n = clusterGrid[r][c];
                if (n == null) continue;
                Node<Pos> rep = BP.find(n);
                areaByRep.put(rep, areaByRep.getOrDefault(rep, 0) + 1);
            }
        }

        boolean[][] outsideWater = new boolean[rows][cols];
        int[] qR = new int[rows * cols], qC = new int[rows * cols];

        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == '0' && !outsideWater[r][0]) bfsWater8(grid, outsideWater, r, 0, qR, qC);
            if (grid[r][cols - 1] == '0' && !outsideWater[r][cols - 1]) bfsWater8(grid, outsideWater, r, cols - 1, qR, qC);
        }
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == '0' && !outsideWater[0][c]) bfsWater8(grid, outsideWater, 0, c, qR, qC);
            if (grid[rows - 1][c] == '0' && !outsideWater[rows - 1][c]) bfsWater8(grid, outsideWater, rows - 1, c, qR, qC);
        }

        boolean[][] seenLake = new boolean[rows][cols];
        int lakeCount = 0, totalLakeArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '0' || outsideWater[i][j] || seenLake[i][j]) continue;

                int h = 0, t = 0;
                qR[t] = i; qC[t] = j; t++;
                seenLake[i][j] = true;

                int lakeArea = 0;
                Node<Pos> owner = null;
                boolean singleOwner = true;

                while (h < t) {
                    int r = qR[h], c = qC[h]; h++; lakeArea++;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + DR8[d], nc = c + DC8[d];
                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                        if (grid[nr][nc] == '0') {
                            if (!outsideWater[nr][nc] && !seenLake[nr][nc]) {
                                seenLake[nr][nc] = true;
                                qR[t] = nr; qC[t] = nc; t++;
                            }
                        } else {
                            Node<Pos> nn = clusterGrid[nr][nc];
                            if (nn != null) {
                                Node<Pos> rr = BP.find(nn);
                                if (owner == null) owner = rr;
                                else if (owner != rr) singleOwner = false;
                            }
                        }
                    }
                }

                lakeCount++;
                totalLakeArea += lakeArea;
                if (singleOwner && owner != null) {
                    areaByRep.put(owner, areaByRep.getOrDefault(owner, 0) + lakeArea);
                }
            }
        }

        int[] sizes = new int[areaByRep.size()];
        int idx = 0;
        for (int v : areaByRep.values()) sizes[idx++] = v;
        Arrays.sort(sizes);
        for (int l = 0, r = sizes.length - 1; l < r; l++, r--) {
            int tmp = sizes[l]; sizes[l] = sizes[r]; sizes[r] = tmp;
        }

        int totalIslandArea = 0;
        for (int v : areaByRep.values()) totalIslandArea += v;

        Res res = new Res();
        res.islands = areaByRep.size();
        res.lakes = lakeCount;
        res.totalIslandArea = totalIslandArea;
        res.totalLakeArea = totalLakeArea;
        res.sizes = sizes;
        return res;
    }

    static void printRes(Res r, PrintWriter out) {
        out.println(r.islands);
        if (r.islands == 0) out.println(-1);
        else {
            for (int i = 0; i < r.sizes.length; i++) {
                if (i > 0) out.print(' ');
                out.print(r.sizes[i]);
            }
            out.println();
        }
        out.println(r.totalIslandArea);
        out.println(r.lakes);
        out.println(r.totalLakeArea);
    }

    static void bfsWater8(char[][] grid, boolean[][] vis, int si, int sj, int[] qR, int[] qC) {
        int rows = grid.length, cols = grid[0].length;
        int h = 0, t = 0;
        qR[t] = si; qC[t] = sj; t++;
        vis[si][sj] = true;
        while (h < t) {
            int r = qR[h], c = qC[h]; h++;
            for (int d = 0; d < 8; d++) {
                int nr = r + DR8[d], nc = c + DC8[d];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] != '0' || vis[nr][nc]) continue;
                vis[nr][nc] = true;
                qR[t] = nr; qC[t] = nc; t++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Reader in  = (args.length >= 1) ? new FileReader(args[0]) : new InputStreamReader(System.in);
        Writer out = (args.length >= 2) ? new FileWriter(args[1]) : new OutputStreamWriter(System.out);
        try (BufferedReader br = new BufferedReader(in);
             PrintWriter pw = new PrintWriter(new BufferedWriter(out))) {

            FS fs = new FS(br);

            Integer S = fs.nextInt();
            Integer T = fs.nextInt();
            if (S == null || T == null) throw new IllegalArgumentException("Missing S T.");
            if (S <= 0 || T <= 0) throw new IllegalArgumentException("Non-positive dimensions.");

            int rows = S, cols = T;

            char[][] grid = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String row = fs.next();
                if (row == null) throw new IllegalArgumentException("Unexpected EOF at row " + i + ".");
                if (row.length() != cols) throw new IllegalArgumentException("Row " + i + " length " + row.length() + " != " + cols + ".");
                for (int j = 0; j < cols; j++) {
                    char ch = row.charAt(j);
                    if (ch != '0' && ch != '1') throw new IllegalArgumentException("Invalid char at (" + i + "," + j + "): " + ch);
                    grid[i][j] = ch;
                }
            }

            Integer F = fs.nextInt();
            if (F == null) throw new IllegalArgumentException("Missing number of phases F.");
            if (F < 0) throw new IllegalArgumentException("Negative F.");

            Partition<Pos> BP = new Partition<>();
            Node<Pos>[][] clusterGrid = makeNodes(grid, BP);

            printRes(Survey(grid, clusterGrid, BP), pw);

            for (int p = 0; p < F; p++) {
                Integer L = fs.nextInt();
                if (L == null) throw new IllegalArgumentException("Missing L for phase " + p + ".");
                if (L < 0) throw new IllegalArgumentException("Negative L at phase " + p + ".");
                for (int k = 0; k < L; k++) {
                    Integer r = fs.nextInt();
                    Integer c = fs.nextInt();
                    if (r == null || c == null) throw new IllegalArgumentException("Phase " + p + " missing coordinate at pair " + k + ".");
                    if (r < 0 || r >= rows || c < 0 || c >= cols) throw new IllegalArgumentException("Phase " + p + " out of bounds (" + r + "," + c + ").");
					if (grid[r][c] == '1') continue;
					grid[r][c] = '1';
					if (clusterGrid[r][c] == null) {
						clusterGrid[r][c] = BP.makeCluster(new Pos(r, c));   // <-- use Pos, capture returned Node
						if (r > 0 && clusterGrid[r - 1][c] != null) BP.union(clusterGrid[r][c], clusterGrid[r - 1][c]);
						if (r + 1 < rows && clusterGrid[r + 1][c] != null) BP.union(clusterGrid[r][c], clusterGrid[r + 1][c]);
						if (c > 0 && clusterGrid[r][c - 1] != null) BP.union(clusterGrid[r][c], clusterGrid[r][c - 1]);
						if (c + 1 < cols && clusterGrid[r][c + 1] != null) BP.union(clusterGrid[r][c], clusterGrid[r][c + 1]);
					}

                }
                printRes(Survey(grid, clusterGrid, BP), pw);
            }

            pw.flush();
        }
    }
}
