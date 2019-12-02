import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Aoc2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\src2"));
        String[] srcString = br.readLine().split(",");
        br.close();
        int[] srcInt = Arrays.stream(srcString).mapToInt(Integer::parseInt).toArray();
        srcInt[1] = 12;
        srcInt[2] = 2;
        for (int i = 0; i < (srcInt.length / 4 + 1); i++) {
            if (srcInt[i * 4] == 99) {
                break;
            }
            if (srcInt[i * 4] == 1) {
                srcInt[srcInt[i * 4 + 3]] = srcInt[srcInt[i * 4 + 1]] + srcInt[srcInt[i * 4 + 2]];
            } else {
                srcInt[srcInt[i * 4 + 3]] = srcInt[srcInt[i * 4 + 1]] * srcInt[srcInt[i * 4 + 2]];
            }
        }
        System.out.println(srcInt[0]);
    }
}
