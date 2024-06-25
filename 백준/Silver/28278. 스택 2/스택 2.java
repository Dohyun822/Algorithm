import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            switch (input.charAt(0)) {
                case '1':
                    int value = Integer.parseInt(input.substring(2));
                    stack.add(value);
                    break;
                case '2':
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.remove(stack.size() - 1)).append("\n");
                    }
                    break;
                case '3':
                    sb.append(stack.size()).append("\n");
                    break;
                case '4':
                    sb.append(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case '5':
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.get(stack.size() - 1)).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}