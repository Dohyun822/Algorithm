import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxPrize = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] dice = new int[3];
            for (int j = 0; j < 3; j++) {
                dice[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(dice);

            int prize = 0;
            if (dice[0] == dice[1] && dice[1] == dice[2]) {
                prize = 10000 + dice[0] * 1000;
            } else if (dice[0] == dice[1] || dice[1] == dice[2]) {
                prize = 1000 + dice[1] * 100;
            } else {
                prize = dice[2] * 100;
            }

            if (prize > maxPrize) {
                maxPrize = prize;
            }
        }

        System.out.println(maxPrize);
    }
}