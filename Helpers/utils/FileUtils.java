package Helpers.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FileUtils {

    public static List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static String readFileToString(String filename) throws IOException {
        return Files.readString(Paths.get(filename));
    }

    public static HashMap<Integer, List<Integer>> parseFileIntoMultiValueMap(String fileName) throws IOException {
        List<String> lines = readFile(fileName);
        HashMap<Integer, List<Integer>> pageRuleSet = new HashMap<>();
    
        for (String line : lines) {
            if (line.contains("|")) {
                String[] columns = line.split("\\|");
                int key = Integer.parseInt(columns[0].trim());
                int value = Integer.parseInt(columns[1].trim());
    
                pageRuleSet.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            }
        }
    
        return pageRuleSet;
    }
    

    public static Pair<List<Integer>, List<Integer>> parseFileIntoPairs(String fileName) throws IOException {
        List<String> lines = readFile(fileName);
        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();

        for (String line : lines) {
            String[] columns = line.split("\\s+");
            column1.add(Integer.parseInt(columns[0]));
            column2.add(Integer.parseInt(columns[1]));
        }

        return new Pair<>(column1, column2);
    }

    public static List<List<Integer>> parseAfterLineBreak(String fileName) throws IOException {
        List<String> lines = readFile(fileName);
        List<String> afterBreak = new ArrayList<>();
        boolean breakFound = false;
    
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                breakFound = true;
            } else if (breakFound) {
                afterBreak.add(line);
            }
        }
    
        return parseFileLinesIntoLists(afterBreak);
    }

    public static List<List<Integer>> parseFileLinesIntoLists(String fileName) throws IOException {
        List<String> lines = readFile(fileName);
        List<List<Integer>> numbers = new ArrayList<>();
    
        for (String line : lines) {
            String[] arrLine = line.split(" "); 
            List<Integer> column = new ArrayList<>();
            
            for (String num : arrLine) {
                column.add(Integer.parseInt(num));
            }
            numbers.add(column);
        }

        return numbers;
    }

    public static List<List<Integer>> parseFileLinesIntoLists(List<String> lines) {
        List<List<Integer>> numbers = new ArrayList<>();
    
        for (String line : lines) {
            String[] arrLine = line.split(",");
            List<Integer> column = new ArrayList<>();
    
            for (String num : arrLine) {
                column.add(Integer.parseInt(num));
            }
            numbers.add(column);
        }
    
        return numbers;
    }
    
}
    
