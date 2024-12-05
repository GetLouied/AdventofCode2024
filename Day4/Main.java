package Day4;

import Helpers.utils.FileUtils;
import Helpers.processing.StringProcessor;
import Helpers.solvers.XmasSolver;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = FileUtils.readFile("resources/xmas.txt");
            char[][] grid = StringProcessor.processToGrid(lines);


            String targetWord = "XMAS";
            int xmasCount = XmasSolver.countXmas(grid, targetWord);
            System.out.println("Count of XMAS occurrences: " + xmasCount);

            int xmasPatternCount = XmasSolver.countMASInXPatterns(lines.toArray(new String[0]), lines.size(), lines.get(0).length());
            System.out.println("Count of X-MAS patterns: " + xmasPatternCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
