package Day1.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static Pair<List<Integer>, List<Integer>> parseFile(String fileName) throws IOException {
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
}
