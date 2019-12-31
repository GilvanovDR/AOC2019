import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aoc4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\input\\src4"));
        String[] range = br.readLine().split("-");
        System.out.println(range[0] + "     " + range[1]);
        long slider = upToValidNum(range[0]);
        long slideMax = Long.parseLong(range[1]);
        System.out.println(slider);
        for (int i = 0; i < 20; i++) {
            System.out.println(slider + " + " + inkI(slider));
            slider += inkI(slider);
        }
/*        while (slider <= slideMax) {
            slider += inkI(slideMax);
            System.out.println(slider);
        }*/
    }

    private static long upToValidNum(String l) {

        int[] intArr = new int[l.length()];
        for (int i = 0; i < l.length(); i++) {
            intArr[i] = l.charAt(i) - '0';
        }
        StringBuilder st = new StringBuilder();
        st.append(intArr[0]);
        for (int i = 1; i < intArr.length; i++) {
            intArr[i] = intArr[i - 1] > intArr[i] ? intArr[i - 1] : intArr[i];
            st.append(intArr[i]);
        }

        return Long.parseLong(st.toString());
    }

    private static long inkI(long oldNum) {
        if (oldNum == 0) {
            return 1;
        }
        int oldNumSize = (int) (Math.log10(oldNum) + 1);
        if (oldNumSize == 1) {
            return 1;
        }
        long newNum = deleteZeroFromNum(oldNum);
        int newSize = (int) (Math.log10(newNum) + 1);
        if ((oldNumSize - newSize) == 0) {
            return 1;
        }
        return (oldNum / newNum) / 10 * (newNum % 10);
    }

    private static long deleteZeroFromNum(long oldNum) {
        while ((oldNum % 10) == 0) {
            oldNum /= 10;
        }
        return oldNum;
    }

}