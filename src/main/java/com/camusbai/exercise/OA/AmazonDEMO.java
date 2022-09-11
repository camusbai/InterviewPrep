package com.camusbai.exercise.OA;

import java.util.*;

public class AmazonDEMO {
    public static List<String> processLogs(List<String> logs, int threshold) {
        if (logs == null || logs.size() == 0) return Collections.emptyList();
        Map<String, Integer> count = new HashMap<>(logs.size() * 4);
        for (String log : logs) {
            String[] segments = log.split(" ");
            String id1 = segments[0];
            String id2 = segments[1];
            count.put(id1, count.getOrDefault(id1, 0) + 1);
            if (!id1.equals(id2)) {
                count.put(id2, count.getOrDefault(id2, 0) + 1);
            }
        }

        Set<String> result = new TreeSet<>((a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }
        return new ArrayList<>(result);
    }

    public static int countGroups(List<String> related) {
        int n = related.size();
        boolean[] visited = new boolean[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(related, i, visited);
            groups++;
        }

        return groups;
    }

    private static void dfs(List<String> related, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        String iRelated = related.get(i);
        for (int j = 0; j < related.size(); j++) {
            if (i == j) continue;
            if (iRelated.charAt(j) == '1') {
                dfs(related, j, visited);
            }
        }
    }
}
