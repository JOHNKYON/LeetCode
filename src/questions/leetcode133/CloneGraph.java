package questions.leetcode133;

import java.util.*;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (null == node) {return null;}
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

        map.put(newNode.label, newNode);


        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode n = queue.pop();
            for (UndirectedGraphNode neighbor : n.neighbors){
                if (!map.containsKey(neighbor.label)){
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }

        return newNode;
    }
}
