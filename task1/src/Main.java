import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = i+1;
        }
        String res = "";
        int step = 0;
        boolean stop = false;
        while(!stop){
            res += String.valueOf(nums[step]);
            step = (step + m);
            if(step > n && step % n != 0) step = step % n - 1;
            else if(step % n == 0) step = 0;
            else step = step - 1;
            stop = step == 0;
        }
        System.out.println(res);
    }
}