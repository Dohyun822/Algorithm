import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Card> cardList;
    static ArrayList<String> colors;
    static ArrayList<Integer> numbers;
    static int[] numberCount;
    static int answer, maxNumber;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        answer = Integer.MIN_VALUE;
        maxNumber = Integer.MIN_VALUE;
        cardList = new ArrayList<>();
        colors = new ArrayList<>();
        numbers = new ArrayList<>();
        numberCount = new int[10];

        // 1. 카드 정보 입력
        for (int i = 0; i < 5; i++) {
            String color = sc.next();
            int number = sc.nextInt();

            cardList.add(new Card(color, number));
        }

        // 2. 정렬
        Collections.sort(cardList);

        // 3. 숫자, 색상 갯수 세기
        for (int i = 0; i < 5; i++) {
            Card currentCard = cardList.get(i);

            // 숫자별 갯수 세기
            numberCount[currentCard.number]++;

            // 최대 숫자 찾기
            maxNumber = Math.max(maxNumber, currentCard.number);

            // 숫자 리스트에 추가
            if (!numbers.contains(currentCard.number))
                numbers.add(currentCard.number);

            // 색상 리스트에 추가
            if (!colors.contains(currentCard.color))
                colors.add(currentCard.color);
        }

        // 4. 조건에 따라 점수 계산
        if (colors.size() == 1) { // 조건 4: 모두 같은 색상인가?
            answer = Math.max(answer, maxNumber + 600);
        }

        if (numbers.size() == 5) {
            int consecutiveDiff = Math.abs(numbers.get(0) - numbers.get(4));
            // 조건 1: 모두 같은 색상이면서 숫자가 연속적인가?
            if (consecutiveDiff == 4 && colors.size() == 1) {
                answer = Math.max(answer, maxNumber + 900);
            }
            // 조건 5: 숫자가 5장 연속적인가?
            if (consecutiveDiff == 4) {
                answer = Math.max(answer, maxNumber + 500);
            }
        }

        if (numbers.size() == 2) {
            // 조건 2: 숫자가 4장 동일한가?
            if (numberCount[numbers.get(0)] == 4) {
                answer = Math.max(answer, numbers.get(0) + 800);
            } else if (numberCount[numbers.get(1)] == 4) {
                answer = Math.max(answer, numbers.get(1) + 800);
            }

            // 조건 3: 숫자가 3장과 2장 동일한가?
            if (numberCount[numbers.get(0)] == 3 && numberCount[numbers.get(1)] == 2) {
                answer = Math.max(answer, numbers.get(0) * 10 + numbers.get(1) + 700);
            } else if (numberCount[numbers.get(0)] == 2 && numberCount[numbers.get(1)] == 3) {
                answer = Math.max(answer, numbers.get(1) * 10 + numbers.get(0) + 700);
            }
        } else if (numbers.size() == 3) {
            // 조건 6: 숫자가 3장 동일한가?
            for (int i = 0; i < numbers.size(); i++) {
                if (numberCount[numbers.get(i)] == 3) {
                    answer = Math.max(answer, numbers.get(i) + 400);
                    break;
                }
            }

            // 조건 7: 숫자가 2장씩 두 개의 쌍을 이루는가?
            for (int i = 0; i < numbers.size() - 1; i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (numberCount[numbers.get(i)] == 2 && numberCount[numbers.get(j)] == 2) {
                        answer = Math.max(answer, numbers.get(j) * 10 + numbers.get(i) + 300);
                        break;
                    }
                }
            }
        } else if (numbers.size() == 4) {
            // 조건 8: 숫자가 2장 동일한가?
            for (int i = 0; i < numbers.size(); i++) {
                if (numberCount[numbers.get(i)] == 2) {
                    answer = Math.max(answer, numbers.get(i) + 200);
                    break;
                }
            }
        }

        // 조건 9: 아무 조건도 해당되지 않는 경우
        if (answer == Integer.MIN_VALUE) {
            answer = maxNumber + 100;
        }

        System.out.println(answer);
    }
}

class Card implements Comparable<Card> {
    String color;
    int number;

    Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public int compareTo(Card c) {
        return this.number - c.number;
    }
}