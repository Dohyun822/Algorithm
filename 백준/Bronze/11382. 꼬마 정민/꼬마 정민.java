import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long answer = 0;

		answer += Long.parseLong(st.nextToken());
		answer += Long.parseLong(st.nextToken());
		answer += Long.parseLong(st.nextToken());

		System.out.println(answer);

	}// end of main
}// end of class