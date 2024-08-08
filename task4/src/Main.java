import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String path = args[0];
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(Integer.parseInt(line));

            }
            int avg = (list.stream().mapToInt(x -> x).sum())/list.size();
            //System.out.println(avg);
            System.out.println(list.stream().map(x -> Math.abs(x-avg)).mapToInt(x -> x).sum());

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
    }
}