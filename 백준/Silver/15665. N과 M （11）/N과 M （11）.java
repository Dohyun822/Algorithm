import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 및 중복 제거
        Arrays.sort(nums);

        backtrack(0);
        System.out.print(sb.toString());
    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int lastSelected = -1;  // 이전에 선택한 숫자를 저장
        for (int i = 0; i < N; i++) {
            if (nums[i] != lastSelected) {
                selected[depth] = nums[i];
                lastSelected = nums[i];
                backtrack(depth + 1);
            }
        }
    }
}