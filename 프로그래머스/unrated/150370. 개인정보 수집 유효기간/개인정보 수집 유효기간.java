import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		int nowyear = Integer.parseInt(today.substring(0, 4));
		int nowmonth = Integer.parseInt(today.substring(5, 7));
		int nowday = Integer.parseInt(today.substring(8, 10));

		HashMap<String, Integer> hashmap = new HashMap<>();

		for (int i = 0; i < terms.length; i++) {
			hashmap.put(terms[i].substring(0, 1), Integer.parseInt(terms[i].substring(2)));
		}

		int idx = 1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < privacies.length; i++) {
			int getyear = Integer.parseInt(privacies[i].substring(0, 4));
			int getmonth = Integer.parseInt(privacies[i].substring(5, 7));
			int getday = Integer.parseInt(privacies[i].substring(8, 10));

			String kind = privacies[i].substring(11);

			int plus = hashmap.get(kind);
			getmonth += plus;

			if (getmonth > 12) {
				getyear += getmonth / 12;
				getmonth = getmonth % 12;
				if (getmonth == 0) {
					getmonth = 12;
					getyear--;
				}
			}
			
			getday = getday -1;
			
			if(getday== 0) {
				getday = 28;
				getmonth = getmonth - 1;
				if(getmonth == 0) {
					getmonth = 12;
					getyear = getyear-1;
				}
			}

			if (nowyear > getyear) {
				result.add(idx);
			} else if (getyear == nowyear && nowmonth > getmonth) {
				result.add(idx);
			} else if (getyear == nowyear && getmonth == nowmonth && nowday > getday) {
				result.add(idx);
			}
			idx++;

		}
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}

//	public static void main(String[] args) {
//		int[] answer;
//		Solution s = new Solution();
//		answer = s.solution("2020.01.01", new String[] { "Z 3", "D 100" },
//				new String[] { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" });
//		System.out.println(Arrays.toString(answer));
//	}
}