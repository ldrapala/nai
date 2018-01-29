package luke.nai.project.astar;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LukaszDrapala
 */
public class Path<T> {

    private final LinkedList<Node<T>> nodes;
    private final Graph<T> graph;
    private double f;
    private double g;

    public Path(Node<T> initialNode, Graph<T> graph) {
        this.nodes = new LinkedList<>();
        this.nodes.add(initialNode);
        this.f = initialNode.getHeuristicValue();
        this.graph = graph;
    }
    public Path(Path<T> path, Graph<T> graph) {
        this.nodes = new LinkedList<>(path.getNodes());
        this.f = path.getF();
        this.g = path.getG();
        this.graph = graph;
    }

    public void addNode(Node<T> node) {
        sumTotalRealCosts(node);
        estimateCost(node);
        saveNode(node);
    }

    private void sumTotalRealCosts(Node<T> node){
        double cost = getCost(node);
        g += cost;
    }
    
    private void estimateCost(Node<T> node){
        f = g + node.getHeuristicValue();
    }
    
    private void saveNode(Node<T> node){
        nodes.add(node);
    }
    
    public double getCost(Node<T> dest){
        Node<T> from = nodes.getLast();
        double cost = graph.getCost(from, dest);
        return cost;
    }
    
    public boolean isFinished(Node<T> node) {
        return nodes.getLast().equals(node);
    }
    
    public Node<T> getLastNode(){
        return nodes.getLast();
    }

    public double getF() {
        return f;
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public double getG() {
        return g;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nodes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Path<?> other = (Path<?>) obj;
        if (!Objects.equals(this.nodes, other.nodes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for (Node<T> node : nodes) {
            result = result.concat(node.getNodeId().toString());
        }
        return result;
    }

}
