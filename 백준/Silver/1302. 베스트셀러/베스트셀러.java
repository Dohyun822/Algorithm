import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> bookSales = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            bookSales.put(book, bookSales.getOrDefault(book, 0) + 1);
        }

        int maxSales = Collections.max(bookSales.values());
        ArrayList<String> bestSellers = new ArrayList<>();

        for (String key : bookSales.keySet()) {
            if (bookSales.get(key) == maxSales) {
                bestSellers.add(key);
            }
        }

        Collections.sort(bestSellers);
        System.out.println(bestSellers.get(0));
    }
}