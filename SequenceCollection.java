import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author avinash
 * <p></p>“Sequenced Collections“ is a new feature added to existing Collection classes/interfaces
 * that allows them to access the first and the last elements of it using the new default methods.</p>
 * <p>
 * 1. SequencedCollection
 * 2. SequencedSet
 * 3. SequencedMap
 */
public class SequenceCollection {
    public static void main(String[] args) {
        sequenceCollectionExample();
        sequenceSetExample();
        sequenceMapExample();
    }

    private static void sequenceMapExample() {
        LinkedHashMap<String, Integer> input = new LinkedHashMap<>();
        input.put("A", 56);
        input.putLast("Z", 90);
        input.putFirst("a", 56);
        System.out.println("Result = " + input);
    }

    private static void sequenceSetExample() {
        LinkedList<Integer> input = new LinkedList<>();
        input.add(12);
        input.add(56);
        input.addFirst(34);
        input.removeLast();
        input.addLast(89);

        System.out.println("Get the first element - " + input.getFirst() + " and last element " + input.getLast());
        System.out.println("Result = " + input);

    }

    private static void sequenceCollectionExample() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.removeFirst();
        input.addFirst(56);
        input.addLast(89);
        System.out.println("Get the first element - " + input.getFirst() + " and last element " + input.getLast());
        System.out.println("Result = " + input);
    }
}
