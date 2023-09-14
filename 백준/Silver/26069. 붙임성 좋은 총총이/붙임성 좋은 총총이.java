import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> danceMap = new HashMap<>();
        danceMap.put("ChongChong", true);

        for (int i = 0; i < N; i++) {
            String[] people = br.readLine().split(" ");
            String personA = people[0];
            String personB = people[1];

            boolean isDancingA = danceMap.getOrDefault(personA, false);
            boolean isDancingB = danceMap.getOrDefault(personB, false);

            if (isDancingA || isDancingB) {
                danceMap.put(personA, true);
                danceMap.put(personB, true);
            }
        }

        int count = 0;
        for (Boolean isDancing : danceMap.values()) {
            if (isDancing) {
                count++;
            }
        }

        System.out.println(count);
    }
}
