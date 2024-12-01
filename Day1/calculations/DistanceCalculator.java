package Day1.calculations;

import java.util.List;

import Day1.processing.ListProcessor;

public class DistanceCalculator {

    public static int calculateTotalDistance(ListProcessor columns){
        columns.sortLists();
        List<Integer> column1 = columns.getColumn1();
        List<Integer> column2 = columns.getColumn2();
        
        int total = 0;
        for(int i = 0; i < column1.size(); i++){
            int distance = calculateDistance(column1.get(i), column2.get(i));
            total += distance;
        }
        return total;
    }

    private static int calculateDistance(int num1, int num2){
        int distance = Math.abs(num1 - num2);
        return distance;
    }
}
