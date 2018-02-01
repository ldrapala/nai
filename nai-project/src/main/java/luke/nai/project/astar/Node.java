package luke.nai.project.astar;

import java.awt.Color;
import java.util.Objects;

/**
 *
 * @author LukaszDrapala
 * @param <T>
 */
public class Node<T> {

    private final T nodeId;
    private final double heuristicValue;

    public Node(T nodeId, double heuristicValue) {
        this.nodeId = nodeId;
        this.heuristicValue = heuristicValue;
    }

    public T getNodeId() {
        return nodeId;
    }

    public double getHeuristicValue() {
        return heuristicValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nodeId);
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
        final Node<?> other = (Node<?>) obj;
        if (!Objects.equals(this.nodeId, other.nodeId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Node{" + "nodeId=" + nodeId + '}';
    }

}
