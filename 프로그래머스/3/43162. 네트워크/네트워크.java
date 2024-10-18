import java.util.*;

class Solution {
    private static int answer;
    private static ArrayList<Integer>[] graph;
    private static boolean[] linked;

    public int solution(int n, int[][] computers) {
        answer = 0;
        linked = new boolean[n+1];
        graph = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 컴퓨터 연결 정보 그래프 변환
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    graph[i+1].add(j+1);
                }
            }
        }
        
        // 연결된 네트워크를 BFS로 탐색
        for(int i = 1; i <= n; i++) {
            if(!linked[i]) {
                answer++;
                bfs(i);
            }
        }
        
        return answer;
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        linked[start] = true;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int next : graph[node]) {
                if(!linked[next]) {
                    linked[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
