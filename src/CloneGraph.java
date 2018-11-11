import java.util.*;

public class CloneGraph {
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    private UndirectedGraphNode recur(UndirectedGraphNode node) {
        if (map.containsKey(node)) {
            return map.get(node);
        } else {
            UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
            map.put(node, dup);

            for (UndirectedGraphNode neighbor : node.neighbors)
                dup.neighbors.add(recur(neighbor));
            return dup;
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        return recur(node);
    }

    public static void main(String[] args) {
        UndirectedGraphNode root = new UndirectedGraphNode(-1);
        CloneGraph s = new CloneGraph();
        System.out.println(s.cloneGraph(root));
        System.out.println("asdasd");
    }
}
