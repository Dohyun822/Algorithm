import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int size = 1;
        while (size < K) {
            size *= 2;
        }

        int cuts = 0;
        int temp = size;
        if (K != size) {
            while (K > 0) {
                temp /= 2;
                if (K >= temp) {
                    K -= temp;
                    cuts++;
                } else {
                    cuts++;
                }
            }
        }

        System.out.println(size + " " + cuts);
    }
}