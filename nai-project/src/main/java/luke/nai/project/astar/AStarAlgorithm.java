package luke.nai.project.astar;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author LukaszDrapala
 * @param <T>
 */
public class AStarAlgorithm<T> {

    private final Graph<T> graph;
    private final Node<T> source;
    private final Node<T> destination;

    public AStarAlgorithm(Graph<T> graph, Node<T> source, Node<T> destination) {
        this.graph = graph;
        this.source = source;
        this.destination = destination;
    }

    public Path execute() throws Exception {
        Queue<Path<T>> forCalculating = new PriorityQueue<>(new PathComparator());
        Path intialPath = new Path(source, graph);
        forCalculating.add(intialPath);
        Set<Node<T>> visitedNodes = new HashSet<>();
        while (!forCalculating.isEmpty()) {
            Path<T> path = forCalculating.poll();
            if (path.isFinished(destination)) {
                return path;
            }
            visitedNodes.add(path.getLastNode());
            for (Node<T> neighbour : graph.getNeighbours(path.getLastNode())) {
                if (visitedNodes.contains(neighbour)) {
                    continue;
                }
                Path newPath = new Path(path, graph);
                newPath.addNode(neighbour);
                if (!forCalculating.contains(newPath)) {
                    forCalculating.add(newPath);
                }
            }
        }
        throw new Exception("Can't find a path.");
    }

}
