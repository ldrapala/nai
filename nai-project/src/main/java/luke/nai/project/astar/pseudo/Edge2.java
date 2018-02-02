package luke.nai.project.astar.pseudo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LukaszDrapala
 */
public class Edge2<T> {
    
    private final List<Node2<T>> nodes;
    private final double cost;

    public Edge2(Node2<T> n1, Node2<T> n2, double cost) {
        this.nodes = Arrays.asList(n1, n2);
        this.cost = cost;
    }

    public List<Node2<T>> getNodes() {
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
        final Edge2<?> other = (Edge2<?>) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (!Objects.equals(this.nodes, other.nodes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Edge{" + "nodes=" + nodes + '}';
    }
    
}
