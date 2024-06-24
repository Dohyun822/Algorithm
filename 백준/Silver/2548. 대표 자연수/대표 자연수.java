import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 자연수의 개수 N을 읽음
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 N개의 자연수를 읽음
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 정렬
        Arrays.sort(nums);
        
        // 중간 값을 출력
        System.out.println(nums[(N - 1) / 2]);
    }
}
