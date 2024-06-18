import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int x1 = 0; x1 <= N; x1++) {
            for (int y1 = 0; y1 <= M; y1++) {
                for (int x2 = 0; x2 <= N; x2++) {
                    for (int y2 = 0; y2 <= M; y2++) {
                        if ((x1 != x2 || y1 != y2) && cntPoint(x1, y1, x2, y2) == K) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count / 2);

        br.close();
    }

    private static int cntPoint(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        return gcd(dx, dy) + 1;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}