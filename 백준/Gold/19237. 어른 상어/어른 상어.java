import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int K;
    private static int[][] map;
    private static int[][][] smellMap;
    private static int[][] sharkInfo;
    private static int[][][] dirPriority;

    // 방향: 1부터 4까지 사용 (0은 사용하지 않음)
    private static int[] dr = {0, -1, 1, 0, 0};
    private static int[] dc = {0, 0, 0, -1, 1};
    private static int remainCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 격자 크기
        M = Integer.parseInt(st.nextToken()); // 상어 수
        K = Integer.parseInt(st.nextToken()); // 냄새 유지 시간

        map = new int[N][N];
        smellMap = new int[N][N][2]; // 냄새 정보 저장 [상어 번호, 남은 시간]
        sharkInfo = new int[M + 1][4]; // 상어 정보 저장 [존재 여부(0 또는 번호), 행, 열, 방향]
        dirPriority = new int[M + 1][4][4]; // 상어의 방향별 우선순위

        // 맵 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int s = Integer.parseInt(st.nextToken());
                map[i][j] = s;
                if (s != 0) {
                    sharkInfo[s][0] = s; // 상어 번호
                    sharkInfo[s][1] = i; // 행
                    sharkInfo[s][2] = j; // 열
                }
            }
        }

        // 상어의 초기 방향 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            sharkInfo[i][3] = Integer.parseInt(st.nextToken());
        }

        // 상어의 방향 우선순위 입력
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 4; k++) {
                    dirPriority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        remainCnt = M;
        int time = 0;
        // 초기 냄새 뿌리기
        smell();

        while (time++ < 1000) {
            move();
            smell();
            if (remainCnt == 1 && sharkInfo[1][0] != 0) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void move() {
        int[][] nextMap = new int[N][N];
        for (int i = 1; i <= M; i++) {
            if (sharkInfo[i][0] != 0) {
                int nDir = sharkInfo[i][3];
                findDIr(i, nDir);
            }
        }

        // 이동 후 충돌 처리 및 맵 업데이트
        for (int i = 1; i <= M; i++) {
            if (sharkInfo[i][0] != 0) {
                int r = sharkInfo[i][1];
                int c = sharkInfo[i][2];
                if (nextMap[r][c] == 0) {
                    nextMap[r][c] = i;
                } else {
                    // 번호가 작은 상어만 남기고 제거
                    if (nextMap[r][c] < i) {
                        sharkInfo[i][0] = 0; // 현재 상어 제거
                        remainCnt--;
                    } else {
                        sharkInfo[nextMap[r][c]][0] = 0; // 기존 상어 제거
                        remainCnt--;
                        nextMap[r][c] = i; // 현재 상어로 업데이트
                    }
                }
            }
        }

        // 맵 업데이트
        map = nextMap;
    }

    private static void findDIr(int i, int nDir) {
        int[] dir = dirPriority[i][nDir - 1]; // 방향 인덱스 조정
        boolean found = false;
        int tempR = -1;
        int tempC = -1;
        int newDir = -1;

        // 냄새가 없는 칸 탐색
        for (int j = 0; j < 4; j++) {
            int d = dir[j];
            int nr = sharkInfo[i][1] + dr[d];
            int nc = sharkInfo[i][2] + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (smellMap[nr][nc][0] == 0) {
                    tempR = nr;
                    tempC = nc;
                    newDir = d;
                    found = true;
                    break;
                }
            }
        }

        // 없으면 자신의 냄새가 있는 칸 탐색
        if (!found) {
            for (int j = 0; j < 4; j++) {
                int d = dir[j];
                int nr = sharkInfo[i][1] + dr[d];
                int nc = sharkInfo[i][2] + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (smellMap[nr][nc][0] == i) {
                        tempR = nr;
                        tempC = nc;
                        newDir = d;
                        break;
                    }
                }
            }
        }

        // 상어 위치 및 방향 업데이트
        sharkInfo[i][1] = tempR;
        sharkInfo[i][2] = tempC;
        sharkInfo[i][3] = newDir;
    }

    private static void smell() {
        // 기존 냄새의 남은 시간을 1씩 감소
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smellMap[i][j][1] > 0) {
                    smellMap[i][j][1]--;
                    if (smellMap[i][j][1] == 0) {
                        smellMap[i][j][0] = 0; // 냄새 사라짐
                    }
                }
            }
        }

        // 현재 상어들의 위치에 새로운 냄새 뿌리기
        for (int i = 1; i <= M; i++) {
            if (sharkInfo[i][0] != 0) {
                int r = sharkInfo[i][1];
                int c = sharkInfo[i][2];
                smellMap[r][c][0] = i;
                smellMap[r][c][1] = K;
            }
        }
    }
}