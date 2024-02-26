import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line);
            char[] cantorSet = new char[(int)Math.pow(3, N)];
            for(int i = 0; i < cantorSet.length; i++) {
                cantorSet[i] = '-';
            }
            makeCantorSet(cantorSet, 0, cantorSet.length, N);
            System.out.println(cantorSet);
        }
    }

    private static void makeCantorSet(char[] cantorSet, int start, int end, int depth) {
        if(depth == 0) return;
        int segment = (end - start) / 3;
        for(int i = start + segment; i < start + 2 * segment; i++) {
            cantorSet[i] = ' ';
        }
        makeCantorSet(cantorSet, start, start + segment, depth - 1);
        makeCantorSet(cantorSet, start + 2 * segment, end, depth - 1);
    }
}