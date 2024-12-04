package Helpers.calculations;

import java.util.List;

public class MultiplicationCalculator {

    public static int calculateTotal(List<int[]> multiplications) {
        int total = 0;

        for (int[] pair : multiplications) {
            total += pair[0] * pair[1];
        }

        return total;
    }
}
