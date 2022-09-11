package com.camusbai.exercise.graph;

import java.util.*;

public class LC210_CourseScheduleII {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};
        new LC210_CourseScheduleII().findOrder(7, input);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> result = new LinkedHashSet<>();
        Map<Integer, List<Integer>> courseToDependencies = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (courseToDependencies.containsKey(prerequisites[i][0])) {
                courseToDependencies.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> dependencies = new ArrayList<>();
                dependencies.add(prerequisites[i][1]);
                courseToDependencies.put(prerequisites[i][0], dependencies);
            }
        }
        boolean[] visited = new boolean[numCourses];
        for (Integer course : courseToDependencies.keySet()) {
            if (visited[course]) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(course);
            boolean[] visited2 = new boolean[numCourses]; // for finding cycle
            List<Integer> coursePathReversed = new ArrayList<>();
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int cour = q.poll();
                    if (courseToDependencies.containsKey(cour)) {
                        for (Integer dependency : courseToDependencies.get(cour)) {
                            if (visited2[dependency]) {
                                return new int[0];
                            }
                            q.offer(dependency);
                        }
                    }
                    coursePathReversed.add(cour);
                    visited[cour] = true;
                    visited2[cour] = true;
                }
            }
            for (int i = coursePathReversed.size() - 1; i > -1; i--) {
                result.add(coursePathReversed.get(i));
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) result.add(i);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
