import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> c = new HashMap<>();
        Map<Integer, String> b = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String n = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            
            c.put(p, c.getOrDefault(p, 0) + 1);
            if (!b.containsKey(p)) {
                b.put(p, n);
                idx.put(p, i);
            }
        }
        
        int sp = -1;
        int minC = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        
        for (int p : c.keySet()) {
            int cnt = c.get(p);
            if (cnt < minC || (cnt == minC && p < sp)) {
                minC = cnt;
                sp = p;
                minIdx = idx.get(p);
            }
        }
        
        System.out.println(b.get(sp) + " " + sp);
    }
}