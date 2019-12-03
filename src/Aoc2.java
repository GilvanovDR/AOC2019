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
        System.out.println(getFirstItem(12,2,srcInt));
        for (int i = 0; i <121 ; i++) {
            for (int j = 0; j <121 ; j++) {
                if (19690720 == getFirstItem(i, j, srcInt)) {
                    System.out.println(i*100+j);
                    break;
                }
            }
        }
    }

    private static int getFirstItem(int first, int second, int[] srcInt) {
        int[] arr = Arrays.copyOf(srcInt,srcInt.length);
        arr[1] = first;
        arr[2] = second;
        for (int i = 0; i < (arr.length / 4 + 1); i++) {
            if (arr[i * 4] == 99) {
                break;
            }
            if (arr[i * 4] == 1) {
                arr[arr[i * 4 + 3]] = arr[arr[i * 4 + 1]] + arr[arr[i * 4 + 2]];
            } else {
                arr[arr[i * 4 + 3]] = arr[arr[i * 4 + 1]] * arr[arr[i * 4 + 2]];
            }
        }
        return arr[0];
    }
}
