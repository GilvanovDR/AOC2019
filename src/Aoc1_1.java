import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aoc1_1 {

    public static void main(String[] args) throws IOException {
        // write your code here
        int sum = 0;
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\1_1"));
        String buf;

        while (!"".equals(buf = br.readLine())) {
            sum = sum + (int) ((Integer.valueOf(buf)) / 3) - 2;
        }
        System.out.println(sum);

    }
}
