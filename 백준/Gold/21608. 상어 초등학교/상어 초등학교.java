import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] classroom;
    private static int[][] preference;
    private static ArrayList<Integer> order;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        classroom = new int[N + 1][N + 1];
        preference = new int[N * N + 1][4];
        order = new ArrayList<Integer>();

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int studentNum = Integer.parseInt(st.nextToken());
            order.add(studentNum);

            for (int j = 0; j < 4; j++) {
                preference[studentNum][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (Integer num : order) {
            placeStudent(num);
        }

        printAnswer();
    }

    private static void printAnswer() {
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int hap = getScore(i, j);
                answer += hap;
            }
        }
        System.out.println(answer);
    }

    private static int getScore(int i, int j) {
        int cnt = 0;
        int studentNum = classroom[i][j];
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
                int neighbor = classroom[nr][nc];
                for (int l = 0; l < 4; l++) {
                    if (neighbor == preference[studentNum][l]) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        if (cnt == 0) return 0;
        else if (cnt == 1) return 1;
        else if (cnt == 2) return 10;
        else if (cnt == 3) return 100;
        else if (cnt == 4) return 1000;
        return 0;
    }

    private static void placeStudent(Integer num) {
        int[][] prefer = new int[N + 1][N + 1];
        // 좋아하는 학생 수 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (classroom[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
                            int neighbor = classroom[nr][nc];
                            for (int l = 0; l < 4; l++) {
                                if (neighbor == preference[num][l]) {
                                    prefer[i][j]++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        int r = 0;
        int c = 0;
        int maxPrefer = -1;
        int maxEmpty = -1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (classroom[i][j] == 0) {
                    int preferCount = prefer[i][j];
                    int emptyCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        if (ni >= 1 && ni <= N && nj >= 1 && nj <= N) {
                            if (classroom[ni][nj] == 0) {
                                emptyCount++;
                            }
                        }
                    }
                    if (preferCount > maxPrefer) {
                        maxPrefer = preferCount;
                        maxEmpty = emptyCount;
                        r = i;
                        c = j;
                    } else if (preferCount == maxPrefer) {
                        if (emptyCount > maxEmpty) {
                            maxEmpty = emptyCount;
                            r = i;
                            c = j;
                        } else if (emptyCount == maxEmpty) {
                            if (i < r || (i == r && j < c)) {
                                r = i;
                                c = j;
                            }
                        }
                    }
                }
            }
        }
        classroom[r][c] = num;
    }
}