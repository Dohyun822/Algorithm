import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] HI = new int[N];
        int[] ARC = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            HI[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            ARC[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(HI);

        long hiWin = 0;
        long arcWin = 0;
        long draw = 0;

        for (int i : ARC) {
            long winCnt = win(HI, i);
            long loseCnt = lose(HI, i);
            long drawCnt = N - winCnt - loseCnt;

            hiWin += winCnt;
            arcWin += loseCnt;
            draw += drawCnt;
        }

        System.out.println(hiWin + " " + arcWin + " " + draw);
    }

    private static long lose(int[] hi, int i) {
        int s = 0;
        int e = hi.length;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (hi[mid] < i) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }

    private static long win(int[] hi, int i) {
        int s = 0;
        int e = hi.length;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (hi[mid] > i) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return hi.length - s;
    }
}