package luke.nai.project.astar;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.List;
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

    public Path<T> execute() throws Exception {
        Queue<Path<T>> openList = new PriorityQueue<>(new PathComparator());
        Path intialPath = new Path(source, graph);
        openList.add(intialPath);
        Set<Node<T>> closedList = new HashSet<>();
        while (!openList.isEmpty()) {
            Path<T> path = openList.poll();
            if (path.isFinished(destination)) {
                return path;
            }
            closedList.add(path.getLastNode());
            for (Node<T> neighbour : graph.getNeighbours(path.getLastNode())) {
                if (closedList.contains(neighbour)) {
                    continue;
                }
                Path newPath = new Path(path, graph);
                newPath.addNode(neighbour);
                    if (!openList.contains(newPath)) {
                        openList.add(newPath);
                    }
            }
        }
        throw new Exception("Can't find a path.");
    }

}
