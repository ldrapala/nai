package luke.nai.project.astar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LukaszDrapala
 * @param <T>
 */
public class Edge<T> {

    private final List<Node<T>> nodes;
    private final double cost;

    public Edge(Node<T> n1, Node<T> n2, double cost) {
        this.nodes = Arrays.asList(n1, n2);
        this.cost = cost;
    }

    public List<Node<T>> getNodes() {
        return new ArrayList<>(nodes);
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nodes);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
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
        final Edge<?> other = (Edge<?>) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (!Objects.equals(this.nodes, other.nodes)) {
            return false;
        }
        return true;
    }

}
