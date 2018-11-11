import java.util.*;

public class CourseSchedule {
    class Node {
        int val;
        List<Integer> neighbors;
        boolean visited;
        Node(int val) {
            this.val = val;
            this.visited = false;
            this.neighbors = new ArrayList<>();
        }
    }

    private Set<Integer> set = new HashSet<>();
    private Node [] adjList;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        adjList = new Node[numCourses];

        for (int i = 0; i < numCourses; i++)
            adjList[i] = new Node(i);

        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].neighbors.add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!adjList[i].visited)
                if (!dfs(i))
                    return false;
        }
        return true;
    }

    boolean dfs(int nodeId) {
        adjList[nodeId].visited = true;
        set.add(nodeId);
        for (int neighbor : adjList[nodeId].neighbors)
            if (adjList[neighbor].visited) {
                if (set.contains(neighbor))
                    return false;
            }
            else {
                if (!dfs(neighbor))
                    return false;
            }
        set.remove(nodeId);
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();
        // int[][] prerequisites = {
        //         {1, 0},
        //         {0, 2},
        //         {2, 1},
        //         {1, 3},
        //         {2, 3}
        // };

        int[][] prerequisites = {};

        System.out.println(s.canFinish(4, prerequisites));
    }
}
