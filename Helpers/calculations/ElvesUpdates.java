package Helpers.calculations;

import java.util.*;

public class ElvesUpdates {

    public static boolean isUpdateOrdered(List<Integer> update, HashMap<Integer, List<Integer>> pageRules) {
        Map<Integer, Integer> pageIndexMap = new HashMap<>();
        for (int i = 0; i < update.size(); i++) {
            pageIndexMap.put(update.get(i), i);
        }

        for (int i = 0; i < update.size(); i++) {
            int page = update.get(i);
            List<Integer> subsequentPages = pageRules.get(page);
            if (subsequentPages == null) continue;
            for (int subsequentPage : subsequentPages) {
                Integer pageIndex = pageIndexMap.get(page);
                Integer subsequentPageIndex = pageIndexMap.get(subsequentPage);
                if (pageIndex != null && subsequentPageIndex != null && pageIndex > subsequentPageIndex) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int findMiddlePage(List<Integer> update) {
        int size = update.size();
        int middleIndex = size / 2;
        return update.get(middleIndex);
    }

    public static int calculateMiddlePageSum(List<List<Integer>> updates, HashMap<Integer, List<Integer>> pageRules) {
        int totalSum = 0;
        for (List<Integer> update : updates) {
            if (isUpdateOrdered(update, pageRules)) {
                totalSum += findMiddlePage(update);
            }
        }
        return totalSum;
    }

    public static List<Integer> sortUpdate(List<Integer> update, HashMap<Integer, List<Integer>> pageRules) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        List<Integer> sortedUpdate = new ArrayList<>();

        for (int page : update) {
            graph.put(page, new ArrayList<>());
            inDegree.put(page, 0);
        }

        for (Map.Entry<Integer, List<Integer>> entry : pageRules.entrySet()) {
            int page = entry.getKey();
            for (int subsequentPage : entry.getValue()) {
                if (update.contains(page) && update.contains(subsequentPage)) {
                    graph.get(page).add(subsequentPage);
                    inDegree.put(subsequentPage, inDegree.get(subsequentPage) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int currentPage = queue.poll();
            sortedUpdate.add(currentPage);
            for (int nextPage : graph.get(currentPage)) {
                inDegree.put(nextPage, inDegree.get(nextPage) - 1);
                if (inDegree.get(nextPage) == 0) {
                    queue.offer(nextPage);
                }
            }
        }

        return sortedUpdate;
    }

    public static int calculateMiddlePageSumAfterSorting(List<List<Integer>> updates, HashMap<Integer, List<Integer>> pageRules) {
        int totalSum = 0;
        for (List<Integer> update : updates) {
            if (!isUpdateOrdered(update, pageRules)) {
                List<Integer> sortedUpdate = sortUpdate(update, pageRules);
                totalSum += findMiddlePage(sortedUpdate);
            }
        }
        return totalSum;
    }
}
