package luke.nai.project.astar.pseudo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LukaszDrapala
 */
public class Node2<T> {
    
    private final T nodeId;
    private double f;
    private double g;
    private double h = 1;
    private List<Node2<T>> neighbours;
    private Node2<T> parent;

    public Node2(T nodeId) {
        this.nodeId = nodeId;
        this.neighbours = new ArrayList<>();
    }

    public T getNodeId() {
        return nodeId;
    }

    public Node2<T> getParent() {
        return parent;
    }
    
    public void add(Node2<T> node){
        neighbours.add(node);
    }

    public List<Node2<T>> getNeighbours() {
        return neighbours;
    }

    public void setParent(Node2<T> parent) {
        this.parent = parent;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "Node2{" + "nodeId=" + nodeId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nodeId);
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
        final Node2<?> other = (Node2<?>) obj;
        if (!Objects.equals(this.nodeId, other.nodeId)) {
            return false;
        }
        return true;
    }
    
}
