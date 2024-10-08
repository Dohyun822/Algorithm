import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[][] arr;

    private static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[][] cloud;
    private static HashSet<Integer> removedCloudPositions;
    private static HashSet<Integer> cloudPositions;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        cloud = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bibaragi(); // 비바라기 시전 (비 구름이 생김)

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            move(d, s); //모든 구름 이동
            rain(); //각 구름에서 비 내림
            removeCloud(); //구름 삭제
            waterCopy(); // 물복사 버그 마법
            makeCloud(); // 구름 생성
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer += arr[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void makeCloud() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] >= 2) {
                    if (!removedCloudPositions.contains(i * N + j)) {
                        cloud[i][j] = 1;
                        arr[i][j] -= 2; // 구름이 생성된 칸은 물의 양이 2 줄어듬
                    }
                }
            }
        }
    }

    private static void waterCopy() {
        for (Integer pos : cloudPositions) {
            int i = pos / N;
            int j = pos % N;
            if (j == 0) {
                j = N;
                i--;
            }
            // 대각선 방향 확인
            int count = 0;
            if (i - 1 >= 1 && j - 1 >= 1 && arr[i - 1][j - 1] > 0) count++;
            if (i - 1 >= 1 && j + 1 <= N && arr[i - 1][j + 1] > 0) count++;
            if (i + 1 <= N && j - 1 >= 1 && arr[i + 1][j - 1] > 0) count++;
            if (i + 1 <= N && j + 1 <= N && arr[i + 1][j + 1] > 0) count++;
            arr[i][j] += count;
        }
    }

    private static void removeCloud() {
        removedCloudPositions = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j] == 1) {
                    cloud[i][j] = 0;
                    removedCloudPositions.add(i * N + j); // 구름이 사라진 위치 저장
                }
            }
        }
    }

    private static void rain() {
        cloudPositions = new HashSet<Integer>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j] == 1) {
                    arr[i][j]++; // 구름이 있는 칸에 비가 내림
                    cloudPositions.add(i * N + j);

                }
            }
        }
    }

    private static void move(int d, int s) {
        d -= 1; // 방향 인덱스 맞추기
        int[][] newCloud = new int[N + 1][N + 1]; // 새로운 구름 위치 저장

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j] == 1) {
                    cloud[i][j] = 0; // 기존 구름 삭제

                    // 새로운 위치 계산
                    int moveR = ((i - 1 + dr[d] * (s % N)) + N) % N + 1;
                    int moveC = ((j - 1 + dc[d] * (s % N)) + N) % N + 1;

                    newCloud[moveR][moveC] = 1; // 새로운 구름 위치 저장
                }
            }
        }

        // 구름 배열 업데이트
        cloud = newCloud;
    }


    private static void bibaragi() {
        cloud[N][1] = 1;
        cloud[N][2] = 1;
        cloud[N - 1][1] = 1;
        cloud[N - 1][2] = 1;
    }
}