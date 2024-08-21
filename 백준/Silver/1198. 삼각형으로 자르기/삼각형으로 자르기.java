import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]> points = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] point = new int[2];
            point[0] = Integer.parseInt(st.nextToken());
            point[1] = Integer.parseInt(st.nextToken());
            points.add(point);
        }

        double maxArea = 0.0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                for (int k = j + 1; k < points.size(); k++) {
                    double area = calculateArea(points.get(i), points.get(j), points.get(k));
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        System.out.printf("%.1f\n", maxArea);
    }

    static double calculateArea(int[] p1, int[] p2, int[] p3) {
        return Math.abs(p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] - p1[1] * p2[0] - p2[1] * p3[0] - p3[1] * p1[0]) / 2.0;
    }
}
