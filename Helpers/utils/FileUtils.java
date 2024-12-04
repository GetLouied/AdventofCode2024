package Helpers.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static String readFileToString(String filename) throws IOException {
        return Files.readString(Paths.get(filename));
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
    
}
