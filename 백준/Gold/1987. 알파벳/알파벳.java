import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int R;
	static int C;
	static int answer;
	
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static HashSet<Character> set = new HashSet<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		solve(0,0,0);
		System.out.print(answer);
		
	}// end of main
	private static void solve(int r, int c, int cnt) {
		if(set.contains(map[r][c])) {
			answer = Math.max(answer,cnt);
			return;
		}
		set.add(map[r][c]);
		for (int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr <R && nc >=0 && nc< C) {
				solve(nr,nc,cnt+1);
			}
		}
		set.remove((Character)map[r][c]);
		
	}
}// end of class