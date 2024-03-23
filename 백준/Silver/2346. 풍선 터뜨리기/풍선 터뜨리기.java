import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<int[]> balloons = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            balloons.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        ListIterator<int[]> iterator = balloons.listIterator();
        int[] current = null;

        while (!balloons.isEmpty()) {
            if (current == null && iterator.hasNext()) {
                current = iterator.next();
            }
            System.out.print(current[0] + " ");
            int steps = current[1];
            iterator.remove();

            if (balloons.isEmpty()) break;

            if (steps > 0) {
                while (steps-- > 0) {
                    if (!iterator.hasNext()) iterator = balloons.listIterator();
                    current = iterator.next();
                }
            } else {
                while (steps++ < 0) {
                    if (!iterator.hasPrevious()) iterator = balloons.listIterator(balloons.size());
                    current = iterator.previous();
                }
                if (!iterator.hasNext()) iterator = balloons.listIterator();
                current = iterator.next();
            }
        }
    }
}