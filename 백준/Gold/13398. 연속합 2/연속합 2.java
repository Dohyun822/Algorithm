import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp1 = new int[n]; // 왼쪽에서 오른쪽으로 계산
		int[] dp2 = new int[n]; // 오른쪽에서 왼쪽으로 계산

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp1[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
			max = Math.max(max, dp1[i]);
		}

		dp2[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
		}

		for (int i = 1; i < n - 1; i++) {
			max = Math.max(max, dp1[i - 1] + dp2[i + 1]);
		}

		System.out.println(max);
	}
}