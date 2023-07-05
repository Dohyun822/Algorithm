import java.io.*;
import java.util.*;

public class Main {
	private static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();

		while (S != null) {
			System.out.println(S);
			S = br.readLine();
		}
	}

}