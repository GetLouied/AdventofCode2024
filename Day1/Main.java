package Day1;

import java.util.List;

import Helpers.calculations.DistanceCalculator;
import Helpers.calculations.SimilarityScore;
import Helpers.processing.ListProcessor;
import Helpers.utils.FileUtils;
import Helpers.utils.Pair;

public class Main {
    public static void main(String[] args) {
        String filename = "resources/locations.txt";

        try {
            int total = calculateDistanceFromFile(filename);
            System.out.println("The total distance is: " + total);
            int simScore = calculateSimilarityScore(filename);
            System.out.println("The Similarity score is: " + simScore);
        } catch (Exception e) {
            System.err.println(e + ": You could not parse this text file.");
        }
    }

    private static int calculateDistanceFromFile(String filename) throws Exception {
        Pair<List<Integer>, List<Integer>> parsedFile = FileUtils.parseFileIntoPairs(filename);
        List<Integer> col1 = parsedFile.getFirst();
        List<Integer> col2 = parsedFile.getSecond();
        ListProcessor processedLists = new ListProcessor(col1, col2);
        return DistanceCalculator.calculateTotalDistance(processedLists);
    }

    private static int calculateSimilarityScore(String filename) throws Exception {
        Pair<List<Integer>, List<Integer>> parsedFile = FileUtils.parseFileIntoPairs(filename);
        List<Integer> col1 = parsedFile.getFirst();
        List<Integer> col2 = parsedFile.getSecond();
        ListProcessor processedLists = new ListProcessor(col1, col2);
        return SimilarityScore.calculateSimilarityScore(processedLists);
    }
}
