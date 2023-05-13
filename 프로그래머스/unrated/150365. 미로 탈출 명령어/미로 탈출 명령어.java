public class Solution {
    public String solution(int m, int n, int y, int x, int c, int r, int k) {
        int width = r - x, height = c - y;
        int distance = Math.abs(width) + Math.abs(height);
        int count = 0, left = 0, right = 0, down = 0, up = 0;
        int[] current = {x, y};
        StringBuilder answer = new StringBuilder();

        if (distance > k || (distance & 1) != (k & 1)) {
            return "impossible";
        }

        if (width < 0) left = -width;
        else right = width;
        if (height < 0) up = -height;
        else down = height;

        if (distance < k && ((k - distance) >> 1) + y + down <= m) {
            up += (k - distance) >> 1;
            down += (k - distance) >> 1;
        } else if (distance < k) {
            up += m - (y + down);
            down += m - (y + down);
            int add_more = (k - (up + down + left + right)) >> 1;
            left += add_more;
            right += add_more;
        }

        while (count < k)
            if (down > 0 && current[1] < m) {
                answer.append('d');
                current[1]++;
                down--;
                count++;
            } else if (left > 0 && current[0] > 1) {
                answer.append('l');
                current[0]--;
                left--;
                count++;
            } else if (right > 0 && current[0] < n) {
                answer.append('r');
                current[0]++;
                right--;
                count++;
            } else if (up > 0 && current[1] > 1) {
                answer.append('u');
                current[1]--;
                up--;
                count++;
            } else {
                return "impossible";
            }
        
        return answer.toString();
    }
}
