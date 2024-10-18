import java.util.*;
import java.io.*;

public class Main {
    private static int answer;
    private static int N;
    private static int[] T;
    private static int[] P;

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
        
        answer = -123123;
        
        recur(1,0);

        System.out.println(answer);
        
    }

    private static void recur(int day, int money) {
        if(day > N + 1){
            return;
        }
        if(day == N + 1 ){
            answer = Math.max(answer, money);
            return;
        }

        recur(day + 1, money); //일 안함
        recur(day + T[day], money + P[day]);
    }
}