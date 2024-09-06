import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] op = new int[4];
    private static int maxResult = Integer.MIN_VALUE;
    private static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        recur(1, arr[0]);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void recur(int idx, int curResult) {
        if (idx == N) {
            maxResult = Math.max(maxResult, curResult);
            minResult = Math.min(minResult, curResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) {
                    recur(idx + 1, curResult + arr[idx]);
                } else if (i == 1) {
                    recur(idx + 1, curResult - arr[idx]);
                } else if (i == 2) {
                    recur(idx + 1, curResult * arr[idx]);
                } else {
                    recur(idx + 1, curResult / arr[idx]);
                }
                op[i]++;
            }
        }
    }
}
