import java.util.*;

public class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int maxIntensity = 10000001;
        int[][] dp = new int[n+1][3];
        List<List<int[]>> realPath = new ArrayList<>();
        Set<Integer> checkGates = new HashSet<>();
        Set<Integer> checkSummits = new HashSet<>();
        
        // Initialize dp and realPath
        for (int i = 0; i <= n; i++) {
            dp[i] = new int[]{maxIntensity, 0, 0};
            realPath.add(new ArrayList<>());
        }
        
        // Convert gates and summits to set for quick access
        for (int gate : gates) {
            checkGates.add(gate);
        }
        for (int summit : summits) {
            checkSummits.add(summit);
        }
        
        // Construct the realPath
        for (int[] path : paths) {
            realPath.get(path[0]).add(new int[]{path[2], path[1]});
            realPath.get(path[1]).add(new int[]{path[2], path[0]});
        }
        
        // Using PriorityQueue in place of heapq in Python
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int summit : summits) {
            dp[summit] = new int[]{0, summit, summit};
            pq.offer(new int[]{0, summit, summit});
        }
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curIntensity = cur[0];
            int curSummit = cur[1];
            int curPlace = cur[2];
            
            if (checkGates.contains(curPlace)) {
                continue;
            }
            
            int nxtSummit = curSummit;
            
            if (dp[curPlace][0] != curIntensity) {
                continue;
            }
            if (dp[curPlace][1] != curSummit) {
                continue;
            }
            
            for (int[] nxt : realPath.get(curPlace)) {
                int nxtIntensity = nxt[0];
                int nxtPlace = nxt[1];
                
                if (checkSummits.contains(nxtPlace)) {
                    continue;
                }
                int updateIntensity = Math.max(curIntensity, nxtIntensity);
                if (dp[nxtPlace][0] < updateIntensity) {
                    continue;
                } else if (dp[nxtPlace][0] == updateIntensity && dp[nxtPlace][1] <= curSummit) {
                    continue;
                } else {
                    dp[nxtPlace][0] = updateIntensity;
                    dp[nxtPlace][1] = curSummit;
                }
                pq.offer(new int[]{updateIntensity, nxtSummit, nxtPlace});
            }
        }
        
        int answerIntensity = maxIntensity;
        int answerMountain = n+1;
        
        for (int gate : gates) {
            if (dp[gate][0] < answerIntensity) {
                answerIntensity = dp[gate][0];
                answerMountain = dp[gate][1];
            } else if (dp[gate][0] == answerIntensity) {
                if (dp[gate][1] < answerMountain) {
                    answerMountain = dp[gate][1];
                }
            }
        }
        
        return new int[]{answerMountain, answerIntensity};
    }
}
