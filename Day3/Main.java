package Day3;

import Helpers.utils.FileUtils;
import Helpers.processing.StringProcessor;
import Helpers.calculations.MultiplicationCalculator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            String output = FileUtils.readFileToString("resources/corrupted_memory.txt");
            List<int[]> numbers = StringProcessor.extractMultiplications(output); 
            List<int[]> enabledNumbers = StringProcessor.extractEnabledMultiplications(output); 
            int total = MultiplicationCalculator.calculateTotal(numbers);
            int enabledTotal = MultiplicationCalculator.calculateTotal(enabledNumbers);
            System.out.println(total);
            System.out.println(enabledTotal);
        }
        catch (Exception e) {
            System.err.println(e + ": You could not parse this test.");
       }
    }
}
