package org.ricardogarfe.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BenchmarkTest extends TestCase {

  private List<Person> peopleList;
  private double forElapsedSeconds;
  private long forStart;
  private long forEnd;

  /**
   * Create the test case
   *
   * @param testName
   *          name of the test case
   */
  public BenchmarkTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(BenchmarkTest.class);
  }

  @Before
  public void setUp() {

    peopleList = createPeopleList();

    forStart = System.currentTimeMillis();

    List<Person> adultPersonsList = new ArrayList<Person>();
    for (Person person : peopleList) {
      if (person.getAge() > 18) {
        adultPersonsList.add(person);
      }
    }

    forEnd = System.currentTimeMillis();
    long forDelta = forEnd - forStart;
    forElapsedSeconds = forDelta / 1000.0;

  }

  public void testForVsLambda() {

    long foreachStart = System.currentTimeMillis();
    for (Person person : peopleList) {
      System.out.println("Person Age:\t" + person.getAge());
    }
    long foreachEnd = System.currentTimeMillis();
    long foreachDelta = foreachEnd - foreachStart;
    double foreachElapsedSeconds = foreachDelta / 1000.0;

    long lambdaForeachStart = System.currentTimeMillis();
    peopleList.forEach(person -> System.out.println("Person Age:\t" + person.getAge()));
    long lambdaForeachEnd = System.currentTimeMillis();
    long lambdaForeachDelta = lambdaForeachEnd - lambdaForeachStart;
    double lambdaForeachElapsedSeconds = lambdaForeachDelta / 1000.0;

    Assert.assertTrue(
        "Foreach without Lambda is faster !" + "\nForeach elapsed time:\t" + foreachElapsedSeconds + "\n Start:\t"
            + foreachStart + "\n End:\t" + foreachEnd + "\nLambda Foreach elapsed time:\t" + lambdaForeachElapsedSeconds
            + "\n Start:\t" + lambdaForeachStart + "\n End:\t" + lambdaForeachEnd,
        foreachElapsedSeconds > lambdaForeachElapsedSeconds);
  }

  public void testForVsStream() {

    long streamStart = System.currentTimeMillis();

    List<Person> adultPeopleListFromStream = peopleList.stream().filter(person -> person.getAge() > 18)
        .collect(Collectors.toList());

    long streamEnd = System.currentTimeMillis();
    long streamDelta = streamEnd - streamStart;
    double streamElapsedSeconds = streamDelta / 1000.0;

    System.out.println("Adult people stream method:\t" + adultPeopleListFromStream.size());

    Assert.assertTrue("For is faster than Stream !" + "\nFor elapsed time:\t" + forElapsedSeconds + "\n Start:\t"
        + forStart + "\n End:\t" + forEnd + "\nStream elapsed time:\t" + streamElapsedSeconds + "\n Start:\t"
        + streamStart + "\n End:\t" + streamEnd, forElapsedSeconds > streamElapsedSeconds);
  }

  public void testForVsParallelStream() {

    long streamStart = System.currentTimeMillis();

    List<Person> adultPeopleListFromStream = peopleList.stream().filter(person -> person.getAge() > 18)
        .collect(Collectors.toList());

    long streamEnd = System.currentTimeMillis();
    long streamDelta = streamEnd - streamStart;
    double streamElapsedSeconds = streamDelta / 1000.0;

    System.out.println("Adult people stream method:\t" + adultPeopleListFromStream.size());

    Assert.assertTrue("For is faster than Stream !" + "\nFor elapsed time:\t" + forElapsedSeconds + "\n Start:\t"
        + forStart + "\n End:\t" + forEnd + "\nStream elapsed time:\t" + streamElapsedSeconds + "\n Start:\t"
        + streamStart + "\n End:\t" + streamEnd, forElapsedSeconds > streamElapsedSeconds);

    long parallelStreamStart = System.currentTimeMillis();

    List<Person> adultPeopleListFromParallelStream = peopleList.parallelStream().filter(person -> person.getAge() > 18)
        .collect(Collectors.toList());

    long parallelStreamEnd = System.currentTimeMillis();
    long parallelStreamDelta = parallelStreamEnd - parallelStreamStart;
    double parallelStreamElapsedSeconds = parallelStreamDelta / 1000.0;

    System.out.println("Adult people stream method:\t" + adultPeopleListFromParallelStream.size());

    Assert
        .assertTrue(
            "For is faster than Parallel Stream !" + "\nFor elapsed time:\t" + forElapsedSeconds + "\n Start:\t"
                + forStart + "\n End:\t" + forEnd + "\nStream elapsed time:\t" + parallelStreamElapsedSeconds
                + "\n Start:\t" + parallelStreamStart + "\n End:\t" + parallelStreamEnd,
            forElapsedSeconds > parallelStreamElapsedSeconds);

  }

  public List<Person> createPeopleList() {

    peopleList = Arrays.asList(new Person("Joe", 18), new Person("Jim", 22), new Person("John", 30),
        new Person("Martin", 16));

    return peopleList;
  }
}
