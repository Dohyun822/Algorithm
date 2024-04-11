import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for (int i = N; i >= 4; i--) {
            if (isGeumMinSu(i)) {
                System.out.println(i);
                break;
            }
        }
    }
    
    private static boolean isGeumMinSu(int number) {
        String numStr = String.valueOf(number);
        for (char c : numStr.toCharArray()) {
            if (c != '4' && c != '7') {
                return false;
            }
        }
        return true;
    }
}