import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> colorValues = new HashMap<>();
        colorValues.put("black", 0);
        colorValues.put("brown", 1);
        colorValues.put("red", 2);
        colorValues.put("orange", 3);
        colorValues.put("yellow", 4);
        colorValues.put("green", 5);
        colorValues.put("blue", 6);
        colorValues.put("violet", 7);
        colorValues.put("grey", 8);
        colorValues.put("white", 9);
        
        HashMap<String, Long> multipliers = new HashMap<>();
        multipliers.put("black", 1L);
        multipliers.put("brown", 10L);
        multipliers.put("red", 100L);
        multipliers.put("orange", 1000L);
        multipliers.put("yellow", 10000L);
        multipliers.put("green", 100000L);
        multipliers.put("blue", 1000000L);
        multipliers.put("violet", 10000000L);
        multipliers.put("grey", 100000000L);
        multipliers.put("white", 1000000000L);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String color1 = br.readLine().trim();
        String color2 = br.readLine().trim();
        String color3 = br.readLine().trim();

        int value1 = colorValues.get(color1);
        int value2 = colorValues.get(color2);
        long multiplier = multipliers.get(color3);

        long resistanceValue = (value1 * 10 + value2) * multiplier;

        System.out.println(resistanceValue);
    }
}