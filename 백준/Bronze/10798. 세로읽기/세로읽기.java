import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[15][5];
        for(char[] a : arr) {
            Arrays.fill(a, ' ');
        }

        for(int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < input.length; j++) {
                arr[j][i] = input[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[i][j] != ' ') {
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.println(sb.toString());
    }
}