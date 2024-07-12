import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int C;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (chk(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(answer);

    }

    private static boolean chk(int dis) {
        int count = 1;
        int cur = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - cur >= dis) {
                count++;
                cur = arr[i];
            }
            if (count >= C) {
                return true;
            }
        }
        return false;
    }
}