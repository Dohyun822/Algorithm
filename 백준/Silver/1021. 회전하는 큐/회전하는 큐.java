import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int totalMoves = 0;
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = queue.indexOf(target);

            // 왼쪽과 오른쪽 이동 중, 최소 이동을 계산
            int left = targetIdx;
            int right = queue.size() - targetIdx;

            totalMoves += Math.min(left, right);

            // 뽑아낸 수를 큐에서 제거
            for (int j = 0; j < Math.min(left, right); j++) {
                if (left < right) {
                    queue.addLast(queue.pollFirst());
                } else {
                    queue.addFirst(queue.pollLast());
                }
            }
            queue.pollFirst();  // 해당 위치의 수 뽑아내기
        }

        System.out.println(totalMoves);
    }
}