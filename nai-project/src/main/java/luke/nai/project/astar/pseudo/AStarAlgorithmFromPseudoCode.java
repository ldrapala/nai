package luke.nai.project.astar.pseudo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import luke.nai.project.astar.gui.Point;

public class AStarAlgorithmFromPseudoCode {

    private final Node2<Point> start;
    private final Node2<Point> end;
    private final Graph2<Point> graph;

    public AStarAlgorithmFromPseudoCode(Graph2<Point> graph, Node2<Point> start, Node2<Point> end) {
        this.graph = graph;
        this.start = start;
        this.end = end;
    }

    public List<Node2<Point>> execute() {
        Set<Node2<Point>> closedList = new HashSet<>();
        Queue<Node2<Point>> openList = new PriorityQueue<>(
                (Node2<Point> o1, Node2<Point> o2) -> Double.compare(o1.getF(), o2.getF()));
        start.setG(0);
        openList.add(start);
        System.out.println("START: " + start);
        System.out.println("END: " + end);
        while (!openList.isEmpty()) {
            Node2<Point> x = openList.poll();
            System.out.println("X: "+x);
            if (x.equals(end)) {
                List<Node2<Point>> reconstructPath = reconstructPath(x);
                System.out.println("END: "+reconstructPath);
                return reconstructPath;
            }
            closedList.add(x);
            for (Node2<Point> y : graph.getNeighbours(x)) {
                System.out.println("Y: "+y);
                if (closedList.contains(y)) {
                    continue;
                }
                double tentativeG = x.getG() + 1;
                boolean tenetativeBetter = false;
                if (!openList.contains(y)) {
                    openList.add(y);
                    y.setH(getHeuristic(y.getNodeId()));
                    tenetativeBetter = true;
                } else if (tentativeG < y.getG()) {
                    tenetativeBetter = true;
                }
                if (tenetativeBetter) {
                    y.setParent(x);//???
//                    came_from[y] := x
                    y.setG(tentativeG);
                    y.setF(tentativeG + y.getH());
                }
            }
        }
        System.out.println("NULL");
        return null;
    }

    private List<Node2<Point>> reconstructPath(Node2<Point> node) {
        List<Node2<Point>> result = new ArrayList<>();
        Node2<Point> currentNode = node;
        while (currentNode.getParent() != null) {
            result.add(0, currentNode.getParent());
            currentNode = currentNode.getParent();
        }
        return result;
//     if (cameFrom[current_node] is set){
//         p = reconstruct_path(cameFrom,cameFrom[current_node]);
//         return (p + current_node);
//             } else{
//         return new ArrayList<>();
//                 }
    }

    private double getHeuristic(Point point) {
        double heuristic = Math.abs(point.getX() - end.getNodeId().getX()) + Math.abs(point.getY() - end.getNodeId().getY());
        return heuristic;
    }

}
