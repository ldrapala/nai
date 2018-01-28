package luke.nai.project.hillclimbing;

import java.util.Random;

/**
 *
 * @author luke
 */
public class Test {

    public static void main(String[] args) {
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
