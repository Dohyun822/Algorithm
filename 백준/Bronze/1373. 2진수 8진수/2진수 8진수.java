import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String b = br.readLine();
        StringBuilder o = new StringBuilder();

        int l = b.length();
        if (l % 3 == 1) {
            b = "00" + b;
        } else if (l % 3 == 2) {
            b = "0" + b;
        }

        for (int i = 0; i < b.length(); i += 3) {
            int s = (b.charAt(i) - '0') * 4 + (b.charAt(i + 1) - '0') * 2 + (b.charAt(i + 2) - '0');
            o.append(s);
        }

        System.out.println(o.toString());
    }
}