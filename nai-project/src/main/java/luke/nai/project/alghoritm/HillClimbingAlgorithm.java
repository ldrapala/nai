package luke.nai.project.alghoritm;

import java.util.function.Function;
import java.util.function.Supplier;

public class HillClimbingAlgorithm<T extends Comparable<T>> {

    private final T s0;
    private final Function<T, T> fitness;
    private final Supplier<Boolean> terminateCondition;
    private final Function<T, T> neighbourSupplier;

    private HillClimbingAlgorithm(Builder<T> builder) {
        this.s0 = builder.s0;
        this.fitness = builder.fitness;
        this.terminateCondition = builder.terminateCondition;
        this.neighbourSupplier = builder.neighbourSupplier;
    }

    public T execute() {
        T s = s0;
        while (!terminateCondition.get()) {
            T newSolution = neighbourSupplier.apply(s);
            if (fitness.apply(newSolution).compareTo(fitness.apply(s)) >= 0) {
                s = newSolution;
            }
        }
        return s;
    }

    public static class Builder<T extends Comparable<T>> {

        private T s0;
        private Function<T, T> fitness;
        private Supplier<Boolean> terminateCondition;
        private Function<T, T> neighbourSupplier;

        public Builder<T> s0(T s0) {
            this.s0 = s0;
            return this;
        }

        public Builder<T> fitness(Function<T, T> fitness) {
            this.fitness = fitness;
            return this;
        }

        public Builder<T> terminateCondition(Supplier<Boolean> terminateCondition) {
            this.terminateCondition = terminateCondition;
            return this;
        }

        public Builder<T> neighbourSupplier(Function<T, T> neighbourSupplier) {
            this.neighbourSupplier = neighbourSupplier;
            return this;
        }

        public HillClimbingAlgorithm<T> build() {
            assert s0 != null;
            assert fitness != null;
            assert terminateCondition != null;
            assert neighbourSupplier != null;
            return new HillClimbingAlgorithm<>(this);
        }

    }

}
