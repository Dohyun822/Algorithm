import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long straightPath = (x + y) * w;
        long diagMaxPath = ((x + y) % 2 == 0) ? Math.max(x, y) * s : (Math.max(x, y) - 1) * s + w;
        long mixPath = (Math.min(x, y)) * s + (Math.abs(x - y)) * w;

        long answer = Math.min(straightPath, Math.min(diagMaxPath, mixPath));

        System.out.println(answer);
    }
}
