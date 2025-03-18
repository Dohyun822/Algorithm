import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> totalTime = new HashMap<>();
        HashMap<String, Integer> inTime = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            int time = toMinutes(parts[0]);
            String num = parts[1];
            String info = parts[2];

            if (info.equals("IN")) {
                inTime.put(num, time);
            } else {
                int parkedTime = time - inTime.get(num);
                totalTime.put(num, totalTime.getOrDefault(num, 0) + parkedTime);
                inTime.remove(num);
            }
        }

        for (String car : inTime.keySet()) {
            int parkedTime = toMinutes("23:59") - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + parkedTime);
        }

        List<String> sortedCars = new ArrayList<>(totalTime.keySet());
        Collections.sort(sortedCars);

        int[] answer = new int[sortedCars.size()];
        for (int i = 0; i < sortedCars.size(); i++) {
            answer[i] = calculateFee(totalTime.get(sortedCars.get(i)), fees);
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    private int calculateFee(int totalTime, int[] fees) {
        int baseTime = fees[0], baseFee = fees[1];
        int unitTime = fees[2], unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        }

        int extraTime = totalTime - baseTime;
        int extraFee = (int) Math.ceil((double) extraTime / unitTime) * unitFee;

        return baseFee + extraFee;
    }
}
