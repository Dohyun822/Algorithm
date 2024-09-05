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

        int[] weights = new int[26];

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                int weight = (int) Math.pow(10, len - 1 - i); 
                weights[ch - 'A'] += weight;
            }
        }

        Integer[] weightIndex = new Integer[26];
        for (int i = 0; i < 26; i++) {
            weightIndex[i] = i;
        }

        Arrays.sort(weightIndex, (a, b) -> weights[b] - weights[a]);

        int[] numberMap = new int[26];  
        int number = 9;
        for (int i = 0; i < 26; i++) {
            if (weights[weightIndex[i]] > 0) {
                numberMap[weightIndex[i]] = number--;
            }
        }

        int result = 0;
        for (String word : words) {
            int len = word.length();
            int num = 0;
            for (int i = 0; i < len; i++) {
                num = num * 10 + numberMap[word.charAt(i) - 'A'];
            }
            result += num;
        }

        System.out.println(result);
    }
}
