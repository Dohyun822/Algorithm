import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Info implements Comparable<Info> {
        int start, end, cnt;
        public Info(int start, int end, int cnt) {
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            if(this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마을 수
        int C = Integer.parseInt(st.nextToken()); // 트럭 용량
        int M = Integer.parseInt(br.readLine()); // 박스 정보의 개수

        PriorityQueue<Info> q = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            q.add(new Info(start, end ,cnt));
        }

        int[] cap = new int[N+1]; // 각 마을의 현재 박스 용량

        int answer = 0;
        while(!q.isEmpty()) {
            Info info = q.poll();
            int max = 0;

            for(int i = info.start; i < info.end; i++) {
                max = Math.max(max, cap[i]);
            }

            max = Math.min(C - max, info.cnt); // 추가로 실을 수 있는 박스 수 계산

            for(int i = info.start; i < info.end; i++) {
                cap[i] += max;
            }

            answer += max;
        }

        System.out.println(answer); // 최대 배송 가능 박스 수 출력
    }
}