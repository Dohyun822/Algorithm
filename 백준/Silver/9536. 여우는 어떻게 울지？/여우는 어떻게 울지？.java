import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            HashSet<String> knownSounds = new HashSet<>();
            StringBuilder result = new StringBuilder();
            
            while (st.hasMoreTokens()) {
                result.append(st.nextToken()).append(" ");
            }
            
            String line;
            while (!(line = br.readLine()).equals("what does the fox say?")) {
                st = new StringTokenizer(line);
                st.nextToken();
                st.nextToken();
                knownSounds.add(st.nextToken());
            }
            
            st = new StringTokenizer(result.toString());
            result.setLength(0);
            while (st.hasMoreTokens()) {
                String sound = st.nextToken();
                if (!knownSounds.contains(sound)) {
                    result.append(sound).append(" ");
                }
            }
            
            sb.append(result.toString().trim()).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}