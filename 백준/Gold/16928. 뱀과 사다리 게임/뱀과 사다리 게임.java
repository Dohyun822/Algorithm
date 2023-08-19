import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    static class Position {
        int num, count;

        Position(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static int bfs() {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Position current = q.poll();
            int num = current.num;

            if (num == 100) return current.count;

            for (int i = 1; i <= 6; i++) {
                int nextNum = num + i;

                if (nextNum <= 100 && !visited[nextNum]) {
                    visited[nextNum] = true;

                    // 사다리나 뱀이 있는 경우 해당 위치로 이동
                    if (board[nextNum] != 0) {
                        nextNum = board[nextNum];
                    }
                    q.offer(new Position(nextNum, current.count + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        System.out.println(bfs());
    }
}