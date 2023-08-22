import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	private static int N;
	private static int A;
	private static int B;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		Set<Point> pointSet = new HashSet<Point>();
		Point[] points = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i] = new Point(x, y);
			pointSet.add(points[i]);
		}

		answer = 0;

		for (Point point : points) {
			Point weight = new Point(point.x + A, point.y);
			Point height = new Point(point.x, point.y + B);
			Point diagonal = new Point(point.x + A, point.y + B);

			if (pointSet.contains(weight) && pointSet.contains(height) && pointSet.contains(diagonal)) {
				answer++;
			}

		}

		System.out.println(answer);

	}
}