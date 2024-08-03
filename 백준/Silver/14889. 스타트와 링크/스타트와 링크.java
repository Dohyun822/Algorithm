import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] S;
    private static int answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;

        recur(0, 0);

        System.out.println(answer);
    }

    private static void recur(int idx, int count) {
        if (count == N / 2) {
            getAnswer();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recur(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    private static void getAnswer() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        int dif = Math.abs(startTeam - linkTeam);

        if (dif < answer) {
            answer = dif;
        }
    }
}