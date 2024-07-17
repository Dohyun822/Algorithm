import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(left(heights));
        System.out.println(right(heights));
    }

    private static int left(int[] heights) {
        int max = 0;
        int count = 0;

        for (int height : heights) {
            if (height > max) {
                max = height;
                count++;
            }
        }

        return count;
    }

    private static int right(int[] heights) {
        int max = 0;
        int count = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                count++;
            }
        }

        return count;
    }
}