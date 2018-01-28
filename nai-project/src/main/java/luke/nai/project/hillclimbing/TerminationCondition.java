package luke.nai.project.hillclimbing;

import java.util.function.Supplier;

/**
 *
 * @author luke
 */
public class TerminationCondition implements Supplier<Boolean> {
    
      private int timeToGo;

        public TerminationCondition(int timeToGo) {
            this.timeToGo = timeToGo;
        }

        @Override
        public Boolean get() {
            timeToGo--;
            return timeToGo <= 0;
        }
    
}
