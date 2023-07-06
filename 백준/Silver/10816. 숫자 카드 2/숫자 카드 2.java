import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.math.*;

public class Main {
	public static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			if(key <= arr[mid]) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	public static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			if(key < arr[mid]) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int [N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr,key)-lowerBound(arr,key)).append(' ');
		}
		System.out.println(sb);
		

	}
}
