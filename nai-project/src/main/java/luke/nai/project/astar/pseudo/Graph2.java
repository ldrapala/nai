package luke.nai.project.astar.pseudo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author LukaszDrapala
 */
public class Graph2<T> {
    
     private final Map<Node2<T>, Set<Edge2<T>>> graph;

    public Graph2() {
        graph = new HashMap<>();
    }

    public void addEdge(Edge2<T> edge) {
        edge.getNodes().forEach((node) -> {
            if (graph.containsKey(node)) {
                Set<Edge2<T>> edges = graph.get(node);
                edges.add(edge);
            } else {
                Set<Edge2<T>> edges = new HashSet<>();
                edges.add(edge);
                graph.put(node, edges);
            }
        });
    }
    
    public Set<Node2<T>> getNeighbours(Node2<T> node) {
        Set<Node2<T>> result = new HashSet<>();
        for (Edge2<T> edge : graph.get(node)) {
            List<Node2<T>> nodes = edge.getNodes();
            result.addAll(nodes);
        }
        result.remove(node);
        return result;
    }
    
}
