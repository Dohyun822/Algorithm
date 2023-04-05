import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] A;
	private static int[] C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = new int[N];
		C = new int[N];

		int size = 0;

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());

			int temp = binarySearch(C, 0, size, A[i]);
			if (temp < 0) {
				temp = temp * -1;
			}
			C[temp] = A[i];
			if (temp == size) {
				size++;
			}
		}

		System.out.println(size);
	}

	private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -low; // key not found.
	}
}