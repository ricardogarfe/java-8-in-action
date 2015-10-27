import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Group personGroup = new Group();

        personGroup.addPersonToGroup(new Person(3));
        personGroup.addPersonToGroup(new Person(5));
        personGroup.addPersonToGroup(new Person(7));
        personGroup.addPersonToGroup(new Person(9));

        List<Person> personList = personGroup.getPersons();

        System.out.println("ForEach Method");        

        long foreachStart = System.currentTimeMillis();
        for (Person person : personList) {
            System.out.println("Person Age:\t" + person.getAge());
        }
        long foreachEnd = System.currentTimeMillis();
        long foreachDelta = foreachEnd - foreachStart;
        double foreachElapsedSeconds = foreachDelta / 1000.0;
        System.out.println("ForEach time:\t" + foreachElapsedSeconds +
            "\n Start:\t" + foreachStart + 
            "\n End:\t" + foreachEnd);

        System.out.println("\nLambda Method");

        long lambdaForeachStart = System.currentTimeMillis();
        personList.forEach(person -> System.out.println("Person Age:\t" + person.getAge()));
        long lambdaForeachEnd = System.currentTimeMillis();
        long lambdaForeachDelta = lambdaForeachEnd - lambdaForeachStart;
        double lambdaForeachElapsedSeconds = lambdaForeachDelta / 1000.0;
        System.out.println("Lambda ForEach time:\t" + lambdaForeachElapsedSeconds +
            "\n Start:\t" + lambdaForeachStart + 
            "\n End:\t" + lambdaForeachEnd);
    }

}