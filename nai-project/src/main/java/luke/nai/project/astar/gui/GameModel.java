package luke.nai.project.astar.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import luke.nai.project.astar.AStarAlgorithm;
import luke.nai.project.astar.Edge;
import luke.nai.project.astar.Graph;
import luke.nai.project.astar.Node;
import luke.nai.project.astar.Path;

/**
 *
 * @author LukaszDrapala
 */
public class GameModel {

    private int rows;
    private Point start;
    private Point end;
    private List<Point> walls = new ArrayList<>();

    public void setRows(int rows) {
        this.rows = rows;
        this.start = null;
        this.end = null;
        this.walls.clear();
    }

    public void setStart(int x, int y) {
        start = new Point(x, y);
    }

    public void clearStart() {
        start = null;
    }

    public void setEnd(int x, int y) {
        end = new Point(x, y);
    }

    public void clearEnd() {
        end = null;
    }

    public void setWall(int x, int y) {
        walls.add(new Point(x, y));
    }

    public void clearWall(int x, int y) {
        walls.remove(new Point(x, y));
    }

    public List<Point> start() throws Exception {
        Graph<Point> graph = new Graph<>();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < rows; x++) {
                Point point = new Point(x, y);
                if (isNotWall(point)) {
                    if (hasUpperNeighbour(point)) {
                        Point neighbour = new Point(x, y - 1);
                        if (isNotWall(neighbour)) {
                            graph.addEdge(getStraightEdge(point, neighbour));
                        }
                    }
                    if (hasBottomNeighbour(point)) {
                        Point neighbour = new Point(x, y + 1);
                        if (isNotWall(neighbour)) {
                            graph.addEdge(getStraightEdge(point, neighbour));
                        }
                    }
                    if (hasLeftNeighbour(point)) {
                        Point neighbour = new Point(x - 1, y);
                        if (isNotWall(neighbour)) {
                            graph.addEdge(getStraightEdge(point, neighbour));
                        }
                    }
                    if (hasRightNeighbour(point)) {
                        Point neighbour = new Point(x + 1, y);
                        if (isNotWall(neighbour)) {
                            graph.addEdge(getStraightEdge(point, neighbour));
                        }
                    }
                }
            }
        }
        Node<Point> startNode = new Node<>(start, getHeuristic(start));
        Node<Point> endNode = new Node<>(end, 0);
        AStarAlgorithm<Point> aStarAlgorithm = new AStarAlgorithm<>(graph, startNode, endNode);
        Path<Point> path = aStarAlgorithm.execute();
        List<Node<Point>> nodes = path.getNodes();
        List<Point> result = nodes.stream().map(Node::getNodeId).collect(Collectors.toList());
        return result;
    }

    private boolean isNotWall(Point point) {
        return !walls.contains(point);
    }

    private Edge<Point> getStraightEdge(Point point1, Point point2) {
        return getEdge(point1, point2, 1);
    }

    private Edge<Point> getEdge(Point point1, Point point2, double cost) {
        double heuristic = getHeuristic(point1);
        double heuristic2 = getHeuristic(point2);
        return new Edge<>(new Node<>(point1, heuristic), new Node<>(point2, heuristic2), cost);
    }

    private double getHeuristic(Point point) {
        double heuristic = Math.abs(point.getX() - end.getX()) + Math.abs(point.getY() - end.getY());
        return heuristic;
    }

    private boolean hasUpperNeighbour(Point point) {
        return point.getY() - 1 >= 0;
    }

    private boolean hasBottomNeighbour(Point point) {
        return point.getY() + 1 < rows;
    }

    private boolean hasLeftNeighbour(Point point) {
        return point.getX() - 1 >= 0;
    }

    private boolean hasRightNeighbour(Point point) {
        return point.getX() + 1 < rows;
    }

}
