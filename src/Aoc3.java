import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aoc3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\src3"));
        String[] srcString1 = br.readLine().split(",");
        String[] srcString2 = br.readLine().split(",");
        br.close();
        List<int[]> sections1 = getSections(srcString1);
      /*  for (int[] ints : sections1) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }*/
        List<int[]> sections2 = getSections(srcString2);
        System.out.println(getMinManhettn(sections1, sections2));
    }

    private static int getMinManhettn(List<int[]> sections1, List<int[]> sections2) {
        return 0;
    }

    private static List<int[]> getSections(String[] srcString) {
        char direct;
        int countSteps;
        int slideX = 0;
        int slideY = 0;
        int startX;
        int startY;
        List<int[]> section = new ArrayList<>();
        for (String aSrcString : srcString) {
            startX = slideX;
            startY = slideY;
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
            section.add(new int[]{startX, startY, slideX, slideY});
        }
        return section;
    }
}
