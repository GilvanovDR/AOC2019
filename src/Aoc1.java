import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aoc1 {
    private static int sum1 = 0;
    private static int sum2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\src1"));
        String buf;
        while (!"".equals(buf = br.readLine())) {
            countMass(Integer.valueOf(buf), false);
            countMass(Integer.valueOf(buf), true);
        }
        System.out.println(sum1);
        System.out.println(sum2);
    }

    private static int countMass(int massModule) {
        return (massModule / 3) - 2;
    }

    private static int countMass(int massModule, boolean task) {
        int result = countMass(massModule);
        if (!task) {
            sum1 += result;
        }
        if (task) {
            sum2 += result;
            if (countMass(result) >= 0) {
                countMass(result, true);
            }
        }
        return result;
    }
}
