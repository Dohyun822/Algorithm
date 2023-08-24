import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] restArea = new int[N + 2];

        if (N != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                restArea[i] = Integer.parseInt(st.nextToken());
            }
        }

        restArea[N + 1] = L;

        Arrays.sort(restArea);

        int left = 1;
        int right = L;
        int answer = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i <= N + 1; i++) {
                int diff = restArea[i] - restArea[i - 1] - 1;
                count += (diff / mid);
            }

            if (count > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}