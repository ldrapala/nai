package luke.nai.project;

import java.util.function.Supplier;

/**
 *
 * @author luke
 */
public class Condition implements Supplier<Boolean> {
    
      private int timeToGo;

        public Condition(int timeToGo) {
            this.timeToGo = timeToGo;
        }

        @Override
        public Boolean get() {
            timeToGo--;
            return timeToGo <= 0;
        }
    
}
