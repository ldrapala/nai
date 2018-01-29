package luke.nai.project.astar;

import java.util.Comparator;

/**
 *
 * @author LukaszDrapala
 */
public class PathComparator implements Comparator<Path> {

    @Override
    public int compare(Path p1, Path p2) {
        return Double.compare(p1.getF(), p2.getF());
    }

}
