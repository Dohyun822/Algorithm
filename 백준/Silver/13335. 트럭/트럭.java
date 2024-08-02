import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int weight = 0;

        for (int i = 0; i < n; i++) {
            int truck = trucks[i];

            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    weight += truck;
                    time++;
                    break;
                } else if (bridge.size() == w) {
                    weight -= bridge.poll();
                } else {
                    if (weight + truck <= L) {
                        bridge.add(truck);
                        weight += truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        time += w;

        System.out.println(time);
    }
}
