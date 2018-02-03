package luke.nai.project.astar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

    private final Map<Node<T>, Set<Edge<T>>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(Edge<T> edge) {
        edge.getNodes().forEach((node) -> {
            if (graph.containsKey(node)) {
                Set<Edge<T>> edges = graph.get(node);
                edges.add(edge);
            } else {
                Set<Edge<T>> edges = new HashSet<>();
                edges.add(edge);
                graph.put(node, edges);
            }
        });
    }

    public double getCost(Node<T> from, Node<T> to) {
        Set<Edge<T>> edges = graph.getOrDefault(from, new HashSet<>());
        for (Edge<T> edge : edges) {
            if (edge.getNodes().equals(Arrays.asList(from, to))) {
                return edge.getCost();
            }
        }
        return Double.MAX_VALUE;
    }

    public Set<Node<T>> getNeighbours(Node<T> node) {
        Set<Node<T>> result = new HashSet<>();
        for (Edge<T> edge : graph.getOrDefault(node, new HashSet<>())) {
            List<Node<T>> nodes = edge.getNodes();
            result.addAll(nodes);
        }
        result.remove(node);
        return result;
    }

}
