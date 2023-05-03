class Solution {
	static int R, T, C, F, J, M, A, N;

	public String solution(String[] survey, int[] choices) {
		for (int i = 0; i < choices.length; i++) {
			String type = survey[i];

			String choice = type.substring(0, 1);
			if (choices[i] > 4) {
				choice = type.substring(1, 2);
			}

			int plus = 0;
			switch (choices[i]) {
			case 1:
				plus = 3;
				break;
			case 2:
				plus = 2;
				break;
			case 3:
				plus = 1;
				break;
			case 5:
				plus = 1;
				break;
			case 6:
				plus = 2;
				break;
			case 7:
				plus = 3;
				break;

			}
			switch (choice) {
			case "R":
				R += plus;
				break;
			case "T":
				T += plus;
				break;
			case "C":
				C += plus;
				break;
			case "F":
				F += plus;
				break;
			case "J":
				J += plus;
				break;
			case "M":
				M += plus;
				break;
			case "A":
				A += plus;
				break;
			case "N":
				N += plus;
				break;

			}
		}
		
		String m = "R";
		String b = "C";
		String t = "J";
		String i = "A";
		if(R < T) {
			m = "T";
		}
		if(C < F) {
			b = "F";
		}
		if(J < M) {
			t = "M";
		}
		if(A < N) {
			i = "N";
		}
		return m+b+t+i;
	}
}