import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            reverse(i, j);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void reverse(int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}