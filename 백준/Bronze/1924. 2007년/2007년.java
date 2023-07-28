import java.io.*;
import java.util.*;

public class Main {
	private static int x;
	private static int y;
	private static int[] month;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		month = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int days = 0;
		for (int i = 1; i < x; i++) {
			days += month[i];
		}
		days += y;
		days %= 7;

		String[] day = new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

		System.out.println(day[days]);

	}
}