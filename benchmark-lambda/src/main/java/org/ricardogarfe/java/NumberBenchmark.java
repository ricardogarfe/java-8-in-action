package org.ricardogarfe.java;

public class NumberBenchmark {

    private final int elements;
    private final long elapsedTime;
    private final int activeThreads;

    private NumberBenchmark(int elements, long elapsedTime, int activeThreads) {
        this.elements = elements;
        this.elapsedTime = elapsedTime;
        this.activeThreads = activeThreads;
    }

    public static NumberBenchmark createNumberBenchmark(int elements, long elapsedTime, int activeThreads) {
        return new NumberBenchmark(elements, elapsedTime, activeThreads);
    }

    public int getElements() {
        return elements;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public int getActiveThreads() {
        return activeThreads;
    }

}
