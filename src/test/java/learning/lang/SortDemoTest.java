package learning.lang;

import java.util.Arrays;
import org.junit.Test;

public class SortDemoTest {
    @Test
    public void TwoDimensionArraySortDemo() {
        int[][] array = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        printTwoDimensionArray(array);
    }

    private void printTwoDimensionArray(int[][] arrays) {
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}