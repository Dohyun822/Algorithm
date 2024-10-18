import java.util.*;
import java.io.*;

public class Main {
    private static int answer;
    private static int N;
    private static int[] T;
    private static int[] P;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        

        dp = new int[N+1];
        Arrays.fill(dp, -1);
        
        System.out.println(recur(1));

    }

    private static int recur(int day) {
        if(day > N + 1){
            return -123123123;
        }
        if(day == N + 1 ){
            return 0;
        }

        if(dp[day] != -1){
            return dp[day];
        }

        dp[day] = Math.max(recur(day + 1), recur(day + T[day]) + P[day]);

        return dp[day];
    }
}