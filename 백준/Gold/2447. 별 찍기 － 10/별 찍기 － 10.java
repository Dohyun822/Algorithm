import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.math.*;

public class Main {

	public static void fun(String[][] arr, int x, int y, int N) {
		if(N==1) {
			arr[x][y] = "*";
			return;
		}
		for(int i = 0; i<3; i++) {
			for(int j = 0; j <3; j++) {
				if(!(i==1&&j==1)) {
					fun(arr, x+i*(N/3), y+j *(N/3),N/3);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][N];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				arr[i][j] = " ";
			}

		}
		fun(arr,0,0,N);
		
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}

