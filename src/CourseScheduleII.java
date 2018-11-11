import java.util.*;

public class CourseScheduleII {
    private class Node {
        int val;
        int status;
        // boolean visited;
        List<Integer> neighbors;

        public Node(int val) {
            this.val = val;
            this.status = 0;
            neighbors = new ArrayList <>();
        }
    }

    private Node[] adjList;
    private Stack<Integer> stack = new Stack <>();

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        adjList = new Node[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][1]].neighbors.add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
                return false;
        }

        return true;
    }

    private boolean dfs(int id) {
        if (adjList[id].status == 2) return true;
        if (adjList[id].status == 1) return false;
        adjList[id].status = 1;

        for (int n : adjList[id].neighbors) {
            if (!dfs(n)) return false;
        }

        stack.add(id);
        adjList[id].status = 2;
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) return new int[0];

        int[] res = new int[numCourses];

        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        CourseScheduleII s = new CourseScheduleII();

        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {2, 1},
                {1, 3},
                {2, 3}
        };

        System.out.println(s.findOrder(4, prerequisites));
    }
}
