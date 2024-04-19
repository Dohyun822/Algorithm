import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String status = st.nextToken();
            
            if (status.equals("enter")) {
                set.add(name);
            } else if (status.equals("leave")) {
                set.remove(name);
            }
        }
        
        List<String> remaining = new ArrayList<>(set);
        Collections.sort(remaining, Collections.reverseOrder());
        
        for (String name : remaining) {
            System.out.println(name);
        }
    }
}