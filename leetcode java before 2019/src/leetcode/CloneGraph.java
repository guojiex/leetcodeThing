package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbour : current.neighbors) {
                if (!visited.containsKey(neighbour)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbour.label);
                    visited.put(neighbour,copy);
                    queue.add(neighbour);
                }
                visited.get(current).neighbors.add(visited.get(neighbour));
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }

}
