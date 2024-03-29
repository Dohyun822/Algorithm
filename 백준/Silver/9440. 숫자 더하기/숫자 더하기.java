import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();
			if (line.equals("0"))
				break;

			String[] inputs = line.split(" ");
			String[] li = Arrays.copyOfRange(inputs, 1, inputs.length);
			Arrays.sort(li);

			String num1 = "", num2 = "";
			for (int i = 0; i < li.length; i++) {
				if (!li[i].equals("0")) {
					num1 = li[i];
					if (i + 1 < li.length) {
						num2 = li[i + 1];
						String[] newLi = new String[li.length - 2];
						System.arraycopy(li, 0, newLi, 0, i);
						System.arraycopy(li, i + 2, newLi, i, li.length - i - 2);
						li = newLi;
					} else {
						li = Arrays.copyOfRange(li, 0, i);
					}
					break;
				}
			}

			for (int i = 0; i < li.length; i++) {
				if (i % 2 == 0) {
					num1 += li[i];
				} else if (i < li.length) {
					num2 += li[i];
				}
			}

			System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
		}
	}
}
