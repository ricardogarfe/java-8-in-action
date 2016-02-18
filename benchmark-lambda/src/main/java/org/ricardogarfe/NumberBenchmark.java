package org.ricardogarfe;

public class NumberBenchmark {

  private int elements;
  private long elapsedTime;
  private int activeThreads;

  public NumberBenchmark(int elements, long elapsedTime, int activeThreads) {
    this.elements = elements;
    this.elapsedTime = elapsedTime;
    this.activeThreads = activeThreads;
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
