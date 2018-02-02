package luke.nai.project.astar;

import java.util.Comparator;

/**
 *
 * @author LukaszDrapala
 */
public class PathComparator implements Comparator<Path> {

    @Override
    public int compare(Path p1, Path p2) {
        int compare = Double.compare(p1.getF(), p2.getF());
        if(compare == 0){
            return Double.compare(p1.getHFromLastNode(), p2.getHFromLastNode());
        }
        return compare;
    }

}
