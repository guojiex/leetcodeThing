package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjacantTable = new HashMap<>();
        for (int i = 0; i < prerequisites.length; ++i) {
            if (adjacantTable.get(prerequisites[i][0]) == null) {
                ArrayList<Integer> toAdd = new ArrayList<>();
                toAdd.add(prerequisites[i][1]);
                adjacantTable.put(prerequisites[i][0], toAdd);
            } else {
                adjacantTable.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (isLoopExist(adjacantTable, i, visited)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLoopExist(HashMap<Integer, ArrayList<Integer>> adjacantTable, int i, int[] visited) {
        if (visited[i] == 1)
            return true;
        if (visited[i] == -1)
            return false;
        visited[i] = 1;
        if (adjacantTable.get(i) != null) {
            for (int node : adjacantTable.get(i)) {
                if (isLoopExist(adjacantTable, node, visited)) {
                    return true;
                }
            }
        }
        visited[i] = -1;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] pre = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(2, pre));
    }

}
