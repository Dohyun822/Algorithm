import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            int start = -1;
            int num = -1;
            int diff = 0;
            for (int j = 0; j < c; j++) {
                char x = str.charAt(j);
                if (Character.isDigit(x)) {
                    start = j;
                    num = x - '0';
                } else if (x == 'F') {
                    diff = c - 1 - start;
                }
            }
            if (num != -1) {
                list.add(new int[]{num, diff});
            }
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int[] result = new int[10];
        int diff = -1;
        int idx = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (diff != list.get(i)[1]) {
                idx++;
                diff = list.get(i)[1];
            }
            result[list.get(i)[0]] = idx;
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(result[i]);
        }
    }
}