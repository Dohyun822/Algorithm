import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] counts = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char initial = name.charAt(0);
            counts[initial - 'a']++;
        }

        boolean found = false;
        for (int i = 0; i < 26; i++) {
            if (counts[i] >= 5) {
                System.out.print((char) (i + 'a'));
                found = true;
            }
        }

        if (!found) {
            System.out.println("PREDAJA");
        }
    }
}