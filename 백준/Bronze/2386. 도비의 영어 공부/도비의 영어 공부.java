import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals("#")) {
            char c = line.charAt(0);
            String sentence = line.substring(2);
            int count = 0;

            for (int i = 0; i < sentence.length(); i++) {
                if (Character.toLowerCase(sentence.charAt(i)) == c) {
                    count++;
                }
            }

            System.out.println(c + " " + count);
        }
    }
}
