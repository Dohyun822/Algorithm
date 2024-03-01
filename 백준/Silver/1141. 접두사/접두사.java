import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words);
        
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (!words[i].startsWith(words[i - 1])) {
                count++;
            }
        }

        System.out.println(count);
    }
}