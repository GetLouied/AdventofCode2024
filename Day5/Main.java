package Day5;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import Helpers.utils.FileUtils;
import Helpers.calculations.ElvesUpdates;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName = "resources/pages.txt";
            HashMap<Integer, List<Integer>> pageRuleSet = FileUtils.parseFileIntoMultiValueMap(fileName);
            List<List<Integer>> pagesToBeUpdated = FileUtils.parseAfterLineBreak(fileName);
            int result = ElvesUpdates.calculateMiddlePageSum(pagesToBeUpdated, pageRuleSet);
            int result2 = ElvesUpdates.calculateMiddlePageSumAfterSorting(pagesToBeUpdated, pageRuleSet);
            System.out.println(result);
            System.out.println(result2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
