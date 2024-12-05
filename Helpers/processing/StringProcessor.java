package Helpers.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    public static List<int[]> extractMultiplications(String input) {
        return extract(input, true);
    }

    public static List<int[]> extractEnabledMultiplications(String input) {
        return extract(input, false);
    }

    private static List<int[]> extract(String input, boolean ignoreToggle) {
        List<int[]> results = new ArrayList<>();
        Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)");
        Pattern doPattern = Pattern.compile("do\\(\\)");
        Pattern dontPattern = Pattern.compile("don't\\(\\)");

        boolean isEnabled = true;
        int position = 0;

        while (position < input.length()) {
            Matcher doMatcher = doPattern.matcher(input.substring(position));
            Matcher dontMatcher = dontPattern.matcher(input.substring(position));
            Matcher mulMatcher = mulPattern.matcher(input.substring(position));

            int nextDo = doMatcher.find() ? doMatcher.start() : Integer.MAX_VALUE;
            int nextDont = dontMatcher.find() ? dontMatcher.start() : Integer.MAX_VALUE;
            int nextMul = mulMatcher.find() ? mulMatcher.start() : Integer.MAX_VALUE;

            if (!ignoreToggle && nextDo < nextDont && nextDo < nextMul) {
                isEnabled = true;
                position += doMatcher.end();
            } else if (!ignoreToggle && nextDont < nextDo && nextDont < nextMul) {
                isEnabled = false;
                position += dontMatcher.end();
            } else if (nextMul < nextDo && nextMul < nextDont) {
                if (ignoreToggle || isEnabled) {
                    results.add(new int[]{
                        Integer.parseInt(mulMatcher.group(1)),
                        Integer.parseInt(mulMatcher.group(2))
                    });
                }
                position += mulMatcher.end();
            } else {
                break;
            }
        }

        return results;
    }

    public static char[][] processToGrid(List<String> lines) {
        int rows = lines.size();
        int cols = lines.get(0).length();

        char[][] grid = new char[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }
        
        return grid;
    }
}
