import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N + 1];
        long[] B = new long[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = A[i - 1] + Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            B[i] = B[i - 1] + Long.parseLong(st.nextToken());
        }
        
        Map<Long, Long> cnt = new HashMap<>();
        long answer = 0;
        
        for (int i = 0; i <= N; i++) {
            long diff = A[i] - B[i];
            if (cnt.containsKey(diff)) {
                answer += cnt.get(diff);
            }
            cnt.put(diff, cnt.getOrDefault(diff, 0L) + 1);
        }
        
        System.out.println(answer);
    }
}
