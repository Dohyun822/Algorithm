import java.io.*;
import java.util.*;

public class Main {
	private static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();

		System.out.println(S.charAt(Integer.parseInt(br.readLine()) - 1));

	}

}