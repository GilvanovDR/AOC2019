import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Aoc3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\src3"));
        String[] srcString1 = br.readLine().split(",");
        String[] srcString2 = br.readLine().split(",");
        br.close();
        List<int[]> sections1 = getSections(srcString1);
        List<int[]> sections2 = getSections(srcString2);
        System.out.println(getMinManhattan(sections1, sections2));
    }

    private static int getMinManhattan(List<int[]> sections1, List<int[]> sections2) {
        int minValue = Integer.MAX_VALUE;
        int value;
        for (int[] section1 : sections1) {
            for (int[] section2 : sections2) {
                int[] cross = getCross(section1, section2);
                if (cross != null) {
                    if (cross[0] != 0 || cross[1] != 0) {
                        value = abs(cross[0]) + abs(cross[1]);
                        minValue = minValue < value ? minValue : value;
                    }
                }
            }
        }
        return minValue;
    }

    private static int[] getCross(int[] section1, int[] section2) {
        int crossX = 0;
        int crossY = 0;
        boolean flag = false;
        if (section1[4] != section2[4]) {
            if (section1[4] == 0) {
                if ((section1[1] >= section2[1]) && (section1[1] <= section2[3])
                        && (section2[0] >= section1[0]) && (section2[0] <= section2[2])) {
                    crossX = section1[1];
                    crossY = section2[0];
                    flag = true;
                }
            } else {
                if ((section1[0] >= section2[0]) && (section1[0] <= section2[2])
                        && section2[1] >= section1[1] && section2[1] <= section1[3]) {
                    crossX = section1[0];
                    crossY = section2[1];
                    flag = true;
                }
            }
        }
        if (flag) {
            return (new int[]{crossX, crossY});
        }
        return null;
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
            int directNum = -1;
            switch (direct) {
                case 'U':
                    slideY += countSteps;
                    directNum = 1;
                    break;
                case 'R':
                    slideX += countSteps;
                    directNum = 0;
                    break;
                case 'D':
                    slideY -= countSteps;
                    directNum = 1;
                    break;
                case 'L':
                    directNum = 0;
                    slideX -= countSteps;
                    break;
            }
            if (directNum == 0) {
                if (startX < slideX) {
                    section.add(new int[]{startX, startY, slideX, slideY, directNum});
                } else {
                    section.add(new int[]{slideX, startY, startX, slideY, directNum});
                }
            } else {
                if (startY < slideY) {
                    section.add(new int[]{startX, startY, slideX, slideY, directNum});
                } else {
                    section.add(new int[]{startX, slideY, slideX, startY, directNum});
                }
            }
        }
        return section;
    }
}
