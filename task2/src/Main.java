import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path1 = args[0], path2 = args[1];
        double r, a0, b0, a, b;
        try {
            FileReader fileReader = new FileReader(path1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String[] strs = line.split(" ");
            a0 = Integer.parseInt(strs[0]);
            b0 = Integer.parseInt(strs[1]);
            line = bufferedReader.readLine();
            r = Integer.parseInt(line);

            //System.out.println(a0 + " " + b0 + " " + r);
            bufferedReader.close();

            fileReader = new FileReader(path2);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                strs = line.split(" ");
                a = Integer.parseInt(strs[0]);
                b = Integer.parseInt(strs[1]);
                double d = Math.sqrt(Math.pow(a - a0, 2) + Math.pow(b - b0, 2));
                if(d > r) System.out.println(2);
                else if(d < r) System.out.println(1);
                else System.out.println(0);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
    }
}