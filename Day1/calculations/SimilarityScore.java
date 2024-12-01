package Day1.calculations;

import java.util.List;
import Day1.processing.ListProcessor;
import java.util.Map;
import java.util.HashMap;

public class SimilarityScore {
    public static int calculateSimilarityScore(ListProcessor columns) {
        List<Integer> column1 = columns.getColumn1();
        List<Integer> column2 = columns.getColumn2();

        int similarityScore = 0;
        Map<Integer, Integer> column1Map = createColumnMap(column1);
        Map<Integer, Integer> column2Map = createColumnMap(column2);
        similarityScore = getScore(column1Map, column2Map);
        
        return similarityScore;
    }

    private static Map<Integer, Integer> createColumnMap (List<Integer> column) {
        Map <Integer, Integer> columnMap = new HashMap<Integer, Integer>();
        for(int num: column){
            columnMap.put(num, columnMap.getOrDefault(num, 0) + 1);
        }
        return columnMap;
    }

    private static int getScore(Map<Integer, Integer> col1, Map<Integer, Integer> col2) {
        int score = 0;
        for(int num: col1.keySet()){
            if(col2.containsKey(num)){
                int multiple = col1.get(num);
                int product = num * col2.get(num);
                score = score + (multiple * product);
            }
        }

        return score;
    }

}
