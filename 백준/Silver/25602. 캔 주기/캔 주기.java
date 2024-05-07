import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] cans;
    private static int[][] R, M;
    private static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cans = new int[N];
        R = new int[K][N];
        M = new int[K][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cans[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        recur(0, new int[K], new int[K]);
        System.out.println(max);
    }

    static void recur(int day, int[] RSelected, int[] MSelected) {
        if (day == K) {
            int satisfaction = 0;
            for (int i = 0; i < K; i++) {
                satisfaction += R[i][RSelected[i]];
                satisfaction += M[i][MSelected[i]];
            }
            max = Math.max(max, satisfaction);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (cans[i] > 0) {
                cans[i]--;
                RSelected[day] = i;
                for (int j = 0; j < N; j++) {
                    if (cans[j] > 0) {
                        cans[j]--;
                        MSelected[day] = j;
                        recur(day + 1, RSelected, MSelected);
                        cans[j]++;
                    }
                }
                cans[i]++;
            }
        }
    }
}