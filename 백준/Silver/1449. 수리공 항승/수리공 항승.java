import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] leaks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks);

        int count = 0;
        int lastCovered = 0;

        for (int i = 0; i < N; i++) {
            if (leaks[i] > lastCovered) {
                count++;
                lastCovered = leaks[i] + L - 1;
            }
        }

        System.out.println(count);
    }
}