import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int d = Integer.parseInt(line[1]);
        
        int[] problems = new int[n];
        int hap = 0;
        
        for (int i = 0; i < n; i++) {
            problems[i] = Integer.parseInt(br.readLine());
            hap += problems[i];
        }
        
        int answer = d / hap;
        
        for (int solved : problems) {
            System.out.println(answer * solved);
        }
    }
}