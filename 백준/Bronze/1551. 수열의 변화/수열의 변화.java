import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), ",");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int k = 0; k < K; k++) {
            int[] B = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
                B[i] = A[i + 1] - A[i];
            }
            A = B;
            N--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]);
            if (i < N - 1) {
                sb.append(",");
            }
        }
        
        System.out.println(sb.toString());
    }
}