import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива и интервала: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(m + " " + n);
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
            if(step > n) step = step % n - 1;
            else step = step - 1;
            stop = step == 0;
        }
        System.out.println(res);
    }
}