import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());

		BigInteger[] result = n.divideAndRemainder(m);

		System.out.println(result[0]); // 한 생명체에게 돌아가는 돈의 양
		System.out.println(result[1]); // 1원씩 분배할 수 없는 남는 돈
	}
}