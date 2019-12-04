import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Aoc3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\src3"));
        String[] srcString1 = br.readLine().split(",");
        String[] srcString2 = br.readLine().split(",");
        br.close();
        Map map = new HashMap<String, Integer>();
    }

    private static int[] getSizeMap(String[] srcString1, String[] srcString2) {
        int[] size1 = getSizeFromArray(srcString1);
        int[] size2 = getSizeFromArray(srcString2);
        int[] result = new int[4];
        result[0] = size1[0] < size2[0] ? size1[0] : size2[0];
        result[1] = size1[1] > size2[1] ? size1[1] : size2[1];
        result[2] = size1[2] > size2[2] ? size1[2] : size2[2];
        result[3] = size1[3] < size2[3] ? size1[3] : size2[3];
        return result;
    }

    private static int[] getSizeFromArray(String[] srcString) {
        char direct;
        int countSteps;
        int lowX = 0;
        int lowY = 0;
        int hiX = 0;
        int hiY = 0;
        int slideX = 0;
        int slideY = 0;
        for (String aSrcString : srcString) {
            direct = aSrcString.charAt(0);
            countSteps = Integer.valueOf(aSrcString.substring(1));
            switch (direct) {
                case 'U':
                    slideY += countSteps;
                    break;
                case 'R':
                    slideX += countSteps;
                    break;
                case 'D':
                    slideY -= countSteps;
                    break;
                case 'L':
                    slideX -= countSteps;
                    break;
            }
            lowX = lowX < slideX ? lowX : slideX;
            lowY = lowY < slideY ? lowY : slideY;
            hiX = hiX > slideX ? hiX : slideX;
            hiY = hiY > slideY ? hiY : slideY;
        }
        return new int[]{lowX, hiY, hiX, lowY};
    }
}
