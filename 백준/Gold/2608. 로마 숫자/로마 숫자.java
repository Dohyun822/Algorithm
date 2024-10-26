import java.io.*;
import java.util.*;

public class Main {
    // 로마 숫자를 아라비아 숫자로 변환하기 위한 맵
    static Map<Character, Integer> romanToArabicMap = new HashMap<>();
    // 아라비아 숫자를 로마 숫자로 변환하기 위한 배열
    static int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 로마 숫자를 아라비아 숫자로 변환할 때 사용될 맵 초기화
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);

        // 입력 받기
        String roman1 = br.readLine();
        String roman2 = br.readLine();

        // 로마 숫자를 아라비아 숫자로 변환 후 두 값을 더하기
        int arabic1 = romanToArabic(roman1);
        int arabic2 = romanToArabic(roman2);
        int sum = arabic1 + arabic2;

        // 아라비아 숫자로 출력
        System.out.println(sum);
        // 아라비아 숫자를 로마 숫자로 변환해서 출력
        System.out.println(arabicToRoman(sum));
    }

    // 로마 숫자를 아라비아 숫자로 변환하는 메서드
    public static int romanToArabic(String roman) {
        int sum = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = romanToArabicMap.get(roman.charAt(i));
            if (currentValue < prevValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
            prevValue = currentValue;
        }

        return sum;
    }

    // 아라비아 숫자를 로마 숫자로 변환하는 메서드
    public static String arabicToRoman(int number) {
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (number >= arabicValues[i]) {
                number -= arabicValues[i];
                roman.append(romanSymbols[i]);
            }
        }

        return roman.toString();
    }
}