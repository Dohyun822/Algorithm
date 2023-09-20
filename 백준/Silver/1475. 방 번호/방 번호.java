import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String roomNumber = st.nextToken();
        int[] count = new int[10];

        for (char c : roomNumber.toCharArray()) {
            count[c - '0']++;
        }

        count[6] = (count[6] + count[9] + 1) / 2;
        count[9] = count[6];

        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, count[i]);
        }

        sb.append(max);
        System.out.println(sb.toString());
    }
}