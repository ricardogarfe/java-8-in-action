package org.ricardogarfe;

import java.util.List;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BenchmarkTest extends TestCase {
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

  /**
   * Rigourous Test :-)
   */
  public void testFoo() {
    assertTrue(true);
  }

  public void testForeach() {
    Group personGroup = new Group();

    personGroup.addPersonToGroup(new Person(3));
    personGroup.addPersonToGroup(new Person(5));
    personGroup.addPersonToGroup(new Person(7));
    personGroup.addPersonToGroup(new Person(9));

    List<Person> personList = personGroup.getPersons();

    long foreachStart = System.currentTimeMillis();
    for (Person person : personList) {
      System.out.println("Person Age:\t" + person.getAge());
    }
    long foreachEnd = System.currentTimeMillis();
    long foreachDelta = foreachEnd - foreachStart;
    double foreachElapsedSeconds = foreachDelta / 1000.0;

    long lambdaForeachStart = System.currentTimeMillis();
    personList.forEach(person -> System.out.println("Person Age:\t" + person.getAge()));
    long lambdaForeachEnd = System.currentTimeMillis();
    long lambdaForeachDelta = lambdaForeachEnd - lambdaForeachStart;
    double lambdaForeachElapsedSeconds = lambdaForeachDelta / 1000.0;

    Assert.assertTrue(
        "Foreach without Lambda is faster !" + "\nForeach elapsed time:\t" + foreachElapsedSeconds + "\n Start:\t"
            + foreachStart + "\n End:\t" + foreachEnd + "\nLambda Foreach elapsed time:\t" + lambdaForeachElapsedSeconds
            + "\n Start:\t" + lambdaForeachStart + "\n End:\t" + lambdaForeachEnd,
        foreachElapsedSeconds > lambdaForeachElapsedSeconds);
  }
}
