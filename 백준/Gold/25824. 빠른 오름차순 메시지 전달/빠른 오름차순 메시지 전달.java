import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] input = new int[12][12];
        List<List<Pair>> answer = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 12; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            answer.add(new ArrayList<>());
        }

        answer.get(0).add(new Pair(input[0][1], 1));
        answer.get(0).add(new Pair(input[1][0], 0));

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < answer.get(i - 1).size(); j++) {
                int first = answer.get(i - 1).get(j).first + input[answer.get(i - 1).get(j).second][i * 2] + input[i * 2][i * 2 + 1];
                int second = answer.get(i - 1).get(j).first + input[answer.get(i - 1).get(j).second][i * 2 + 1] + input[i * 2 + 1][i * 2];
                answer.get(i).add(new Pair(first, i * 2 + 1));
                answer.get(i).add(new Pair(second, i * 2));
            }
        }

        int realAnswer = Integer.MAX_VALUE;
        for (Pair tmp : answer.get(5)) {
            if (tmp.first < realAnswer) realAnswer = tmp.first;
        }

        System.out.println(realAnswer);
    }
}