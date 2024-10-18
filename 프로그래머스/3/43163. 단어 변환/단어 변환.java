class Solution {
    private static int answer;
    private static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        int targetIdx = -1;
        visited = new boolean[words.length];
        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i])){
                targetIdx = i;
            }
        }
        if(targetIdx == -1){
            return 0;
        }
        
        recur(begin, target, 0, words);
            
        
        if(answer == Integer.MAX_VALUE){
            return 0;
        }else {
            return answer;
        }
    }
    
    public void recur(String begin, String target, int cnt, String[] words){
        if(cnt > 50){
            return;
        }
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(chk(begin, words[i])){
                if(!visited[i]){
                    visited[i] = true;
                    recur(words[i], target, cnt + 1, words);
                    visited[i] = false;
                }
            }
        }
    }
    
    public boolean chk(String begin, String target){
        boolean[] chklist = new boolean[begin.length()];
        
        for(int i = 0; i < begin.length(); i++){
            char temp = begin.charAt(i);
            for(int j = 0; j < begin.length(); j++){
                if(temp == target.charAt(j)){
                    if(!chklist[j]){
                        chklist[j] = true;
                        break;
                    }
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < begin.length(); i++){
            if(chklist[i]){
                cnt++;
            }
        }
        
        if(cnt + 1 == begin.length()){
            return true;
        }else{
            return false;
        }
    }
}