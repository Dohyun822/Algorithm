import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static class Position {
		int r;
		int c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}

	}

	static String[][] arr;
	private String value;
	private String value2;
	private String command;
	private int r1;
	private int c1;
	private int r2;
	private int c2;
	private int maxIdx;

	static ArrayList<Position>[] mergeList;
	Position cur;

	public String[] solution(String[] commands) {
		arr = new String[51][51];
		ArrayList<String> answer = new ArrayList<String>();
		maxIdx = 2501;

		mergeList = new ArrayList[maxIdx];
		for (int i = 0; i < maxIdx; i++) {
			mergeList[i] = new ArrayList<Position>();
		}

		for (int i = 0; i < commands.length; i++) {
			StringTokenizer st = new StringTokenizer(commands[i], " ");
			command = st.nextToken();
			switch (command) {
			case "UPDATE":
				if (st.countTokens() == 3) {
					r1 = Integer.parseInt(st.nextToken());
					c1 = Integer.parseInt(st.nextToken());
					value = st.nextToken();
					for (int j = 0; j < maxIdx; j++) {
						if (findPosition(j, new Position(r1, c1))) {
							for (int k = 0; k < mergeList[j].size(); k++) {
								int nr = mergeList[j].get(k).r;
								int nc = mergeList[j].get(k).c;
								arr[nr][nc] = value;
							}
							break;
						}
					}
					arr[r1][c1] = value;
				} else {
					value = st.nextToken();
					value2 = st.nextToken();
					for (int r = 1; r < 51; r++) {
						for (int c = 1; c < 51; c++) {
							if (arr[r][c] != null && arr[r][c].equals(value)) {
								arr[r][c] = value2;
								for (int j = 0; j < maxIdx; j++) {
									if (findPosition(j, new Position(r, c))) {
										for (int k = 0; k < mergeList[j].size(); k++) {
											int nr = mergeList[j].get(k).r;
											int nc = mergeList[j].get(k).c;
											arr[nr][nc] = value2;
										}
										break;
									}
								}
							}
						}
					}
				}
				break;
			case "MERGE":
				r1 = Integer.parseInt(st.nextToken());
				c1 = Integer.parseInt(st.nextToken());
				r2 = Integer.parseInt(st.nextToken());
				c2 = Integer.parseInt(st.nextToken());
				if (r1 == r2 && c1 == c2) {
					break;
				}
				boolean chk = true;
				for (int j = 0; j < maxIdx; j++) {
					if (mergeList[j].size() == 0 && j == maxIdx - 1 && chk) {// r1,c1이 단일 셀 인경우
						for (int k = 0; k < maxIdx; k++) {
							if (mergeList[k].size() == 0) {
								mergeList[k].add(new Position(r1, c1));
								addList(k, new Position(r2, c2));// r2,c2가 합병된 셀인지 아닌지 체크하고 경우에 따라 List에 추가
								break;
							}
						}
						chk = false;
					} else if (findPosition(j, new Position(r1, c1))) {// r1,c1 이 합병된 셀인 경우
						addList(j, new Position(r2, c2)); // r2,c2가 합병된 셀인지 아닌지 체크하고 경우에 따라 List에 추가
						break;
					}
				}
				break;
			case "UNMERGE":
				r1 = Integer.parseInt(st.nextToken());
				c1 = Integer.parseInt(st.nextToken());
				for (int j = 0; j < maxIdx; j++) {
					if (findPosition(j, new Position(r1, c1))) {// r1,c1이 있는 합병리스트를 찾는다.
						for (int k = 0; k < mergeList[j].size(); k++) {
							int nr = mergeList[j].get(k).r;
							int nc = mergeList[j].get(k).c;
							if (!(nr == r1 && nc == c1)) {
								arr[nr][nc] = null;
							}
						}
						mergeList[j].clear();
					}
				}
				break;
			case "PRINT":
				r1 = Integer.parseInt(st.nextToken());
				c1 = Integer.parseInt(st.nextToken());
				if (arr[r1][c1] == null) {
					answer.add("EMPTY");
				} else {
					answer.add(arr[r1][c1]);
				}
				break;
			}
		}
		return answer.toArray(new String[answer.size()]);
	}

	private void addList(int idx, Position position) {// arrayList는 r1,c1과 합병관계인 리스트 position은
														// r2,c2
		boolean chk = true;
		ex: for (int i = 0; i < maxIdx; i++) {
			if (findPosition(i, position)) {// r2,c2가 합병된 셀인경우
				for (Position temp : mergeList[idx]) {
					// 이미 r1,c1 과 r2,c2 가 합병된 경우
					if (mergeList[i].contains(temp)) {
						break ex;
					}
				}

				if (arr[mergeList[idx].get(0).r][mergeList[idx].get(0).c] != null) { // r1,c1 값이 null이 아닐 때
					for (int j = 0; j < mergeList[i].size(); j++) {
						arr[mergeList[i].get(j).r][mergeList[i].get(j).c] = arr[mergeList[idx].get(0).r][mergeList[idx]
								.get(0).c];
						mergeList[idx].add(mergeList[i].get(j));
					}
				} else if (arr[mergeList[idx].get(0).r][mergeList[idx].get(0).c] == null
						&& arr[mergeList[i].get(0).r][mergeList[i].get(0).c] != null) {
					for (int j = 0; j < mergeList[idx].size(); j++) {
						arr[mergeList[idx].get(j).r][mergeList[idx].get(j).c] = arr[mergeList[i].get(0).r][mergeList[i]
								.get(0).c];
					}
					for (int j = 0; j < mergeList[i].size(); j++) {
						mergeList[idx].add(mergeList[i].get(j));
					}
				} else {
					for (int j = 0; j < mergeList[i].size(); j++) {
						mergeList[idx].add(mergeList[i].get(j));
					}
				}
				chk = false;
				mergeList[i].clear();
				break;
			}
		}
		if (chk) {// r2,c2가 단일 셀 인경우
			if (arr[mergeList[idx].get(0).r][mergeList[idx].get(0).c] != null) { // r1,c1 값이 null이 아닐 때
				arr[position.r][position.c] = arr[mergeList[idx].get(0).r][mergeList[idx].get(0).c];
			} else if (arr[mergeList[idx].get(0).r][mergeList[idx].get(0).c] == null
					&& arr[position.r][position.c] != null) {
				for (int i = 0; i < mergeList[idx].size(); i++) {
					arr[mergeList[idx].get(i).r][mergeList[idx].get(i).c] = arr[position.r][position.c];
				}
			}
			mergeList[idx].add(position);
		}
	}

	private boolean findPosition(int idx, Position position) {
		return mergeList[idx].contains(position);
	}
}