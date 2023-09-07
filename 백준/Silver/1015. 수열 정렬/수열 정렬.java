import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] P = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            pq.add(new Pair(A[i], i));
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            P[pair.index] = idx++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    static class Pair implements Comparable<Pair> {
        int value, index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return this.index - o.index;
            }
            return this.value - o.value;
        }
    }
}
