import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] calls = br.readLine().split(" ");
        int Y = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            int callTime = Integer.parseInt(calls[i]);
            Y += ((callTime / 30) + 1) * 10;
            M += ((callTime / 60) + 1) * 15;
        }
        if (Y < M) {
            System.out.println("Y " + Y);
        } else if (M < Y) {
            System.out.println("M " + M);
        } else {
            System.out.println("Y M " + Y);
        }
    }
}
