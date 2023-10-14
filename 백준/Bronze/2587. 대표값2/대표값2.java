import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0 ; i<5; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            sum += temp;
        }
        
        Arrays.sort(arr);
        
        System.out.println(sum/5);
        System.out.println(arr[2]);
        
        
    }
}