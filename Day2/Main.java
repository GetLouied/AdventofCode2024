package Day2;

import java.util.List;
import Helpers.calculations.SafetyScore;
import Helpers.utils.FileUtils;

public class Main {
    public static void main(String[] args) {
        String filename = "resources/reports.txt";

        try {
            int score = countOfSafeReports(filename);
            System.out.println("The Safety Score is: " + score);
            int trueScore = trueCountOfSafeReports(filename);
            System.out.println("The Safety Score is: " + trueScore);

        } catch (Exception e) {{
            System.err.println(e + ": You could not parse this test.");
        }}
        
    }

    private static int countOfSafeReports(String filename) throws Exception {
        List<List<Integer>> reports = FileUtils.parseFileLinesIntoLists(filename);
        int score = SafetyScore.calculateSafetyScore(reports);
        return score;

    }

    private static int trueCountOfSafeReports(String filename) throws Exception {
        List<List<Integer>> reports = FileUtils.parseFileLinesIntoLists(filename);
        int score = SafetyScore.calculateTrueSafetyScore(reports);
        return score;

    }

}
