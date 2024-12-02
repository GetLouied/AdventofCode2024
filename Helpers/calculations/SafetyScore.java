package Helpers.calculations;

import java.util.ArrayList;
import java.util.List;

public class SafetyScore {
    public static int calculateSafetyScore(List<List<Integer>> safetyReport) {
        int safetyScore = 0;

        for (List<Integer> arr : safetyReport) {

            if (isGraduallyAscending(arr) || isGraduallyDescending(arr)) {
                safetyScore++;
            }
        }

        return safetyScore;
    }

    public static int calculateTrueSafetyScore(List<List<Integer>> safetyReport) {
        int safetyScore = 0;

        for (List<Integer> arr : safetyReport) {

            if (isTrullyGraduallyAscending(arr) || isTrullyGraduallyDescending(arr)) {
                safetyScore++;
            }
        }

        return safetyScore;
    }

    private static boolean isTrullyGraduallyAscending(List<Integer> arr) {
        if (isGraduallyAscending(arr)) {
            return true;
        }
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> modified = new ArrayList<>(arr);
            modified.remove(i);
            if (isGraduallyAscending(modified)) {
                return true;
            }
        }
        return false;
    }
    

    private static boolean isTrullyGraduallyDescending(List<Integer> arr) {
        if (isGraduallyDescending(arr)) {
            return true;
        }
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> modified = new ArrayList<>(arr);
            modified.remove(i);
            if (isGraduallyDescending(modified)) {
                return true;
            }
        }
        return false;
    }


    private static boolean isGraduallyAscending(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1) 
            || (Math.abs(arr.get(i) - arr.get(i-1)) > 3) 
            || (Math.abs(arr.get(i) - arr.get(i-1)) < 1)) {
                return false; 
            }
        }
        return true;
    }

    private static boolean isGraduallyDescending(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i - 1) 
            || (Math.abs(arr.get(i) - arr.get(i-1)) > 3) 
            || (Math.abs(arr.get(i) - arr.get(i-1)) < 1)) {
                return false; 
            }
        }
        return true;
    }
}
