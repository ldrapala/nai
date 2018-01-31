package luke.nai.project.hillclimbing;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LukaszDrapala
 */
public class HillClimbingAlgorithmTest {

    /**
     * Test of execute method, of class HillClimbingAlgorithm.
     */
    @Test
    public void testExecute() {
        HillClimbingAlgorithm<Double> hillClimbingAlgorithm
                = new HillClimbingAlgorithm.Builder<Double>()
                        .s0(new Random().nextDouble() * 4 - 2)
                        .fitness((Double x) -> 100 - 100 * x * x)
                        .terminateCondition(new TerminationCondition(10_000))
                        .neighbourSupplier((Double x) -> x + (new Random().nextLong() % 1000) / 100_000 - 0.005)
                        .build();
        hillClimbingAlgorithm.execute();
    }

}
