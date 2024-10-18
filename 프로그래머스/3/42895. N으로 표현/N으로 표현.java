class Solution {
    private static int answer;

    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;  // 최솟값을 찾기 위해 큰 값으로 초기화

        // 1번부터 8번까지 N을 사용하여 탐색 시작
        recur(0, 0, N, number);  // 초기값은 0번 사용, 현재 값은 0

        // 답이 8보다 크면 -1 반환
        return (answer > 8) ? -1 : answer;
    }

    // 백트래킹 함수: count는 N 사용 횟수, cur는 현재까지의 계산된 값
    public void recur(int count, int cur, int N, int number) {
        // N을 8번 이상 사용하면 종료
        if (count > 8) {
            return;
        }

        // 현재 값이 목표값과 같으면, 최소 횟수를 갱신하고 종료
        if (cur == number) {
            answer = Math.min(answer, count);
            return;
        }

        // N을 여러 번 이어 붙이는 값 처리 (N, NN, NNN, ...)
        int baseN = 0;
        for (int i = 1; i <= 8 - count; i++) {
            baseN = baseN * 10 + N;  // N, NN, NNN ...을 만들기
            int newCount = count + i;  // N을 i번 사용한 상태로 업데이트

            // 사칙연산을 재귀적으로 호출 (더하기, 빼기, 곱하기, 나누기)
            recur(newCount, cur + baseN, N, number);  // 더하기
            recur(newCount, cur - baseN, N, number);  // 빼기
            recur(newCount, cur * baseN, N, number);  // 곱하기

            // 나누기는 0으로 나누는 경우를 제외
            if (baseN != 0) {
                recur(newCount, cur / baseN, N, number);  // 나누기
            }
        }
    }
}
