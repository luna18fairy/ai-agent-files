/**
 * A generic class representing a fixed-capacity lineup of up to four comparable elements,
 * maintaining either ascending or descending order.
 *
 * @param <T> the type of elements in the lineup; must implement Comparable&lt;T&gt;
 * @author Vaishnavi Manivannan
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Collections;

public class Lineup<T extends Comparable<T>> {
    /** Underlying storage for lineup elements. */
    private ArrayList<T> lineup;
    /** Whether the lineup is sorted in ascending order; if false, descending. */
    private boolean isAscending;

    /**
     * Initializes an empty lineup with capacity for four elements, defaulting to ascending order.
     */
    private Lineup() {
        this.lineup = new ArrayList<>(4);
        this.isAscending = true;
    }

    /**
     * Constructs a lineup from four provided elements, assumed in ascending order.
     * If any element is null, no elements are added.
     *
     * @param first  the first element
     * @param second the second element
     * @param third  the third element
     * @param fourth the fourth element
     */
    public Lineup(T first, T second, T third, T fourth) {
        this(); // constructor chaining
        if (first != null && second != null && third != null && fourth != null) {
            add(first);
            add(second);
            add(third);
            add(fourth);
        }
    }

    /**
     * Returns a string representation of the lineup in the form:
     * "elem0 -> elem1 -> elem2 -> elem3", using "null" for missing slots at the end.
     *
     * @return formatted lineup string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            T elem = (i < lineup.size()) ? lineup.get(i) : null;
            sb.append(elem != null ? elem.toString() : "null");
            if (i < 3) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    /**
     * Attempts to add a non-null element into the lineup at the correct sorted position.
     *
     * @param element the element to add
     * @return true if the element was added; false if full or element is null
     */
    public boolean add(T element) {
        if (element == null || lineup.size() >= 4) {
            return false;
        }
        int idx = 0;
        if (isAscending) {
            while (idx < lineup.size() && lineup.get(idx).compareTo(element) <= 0) {
                idx++;
            }
        } else {
            while (idx < lineup.size() && lineup.get(idx).compareTo(element) >= 0) {
                idx++;
            }
        }
        lineup.add(idx, element);
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from the lineup.
     *
     * @param element the element to remove (non-null)
     * @return true if an element was removed; false otherwise
     */
    public boolean remove(T element) {
        for (int i = 0; i < lineup.size(); i++) {
            if (lineup.get(i).equals(element)) {
                lineup.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Reverses the order of elements in the lineup and toggles the sort direction.
     */
    public void reverseLineup() {
        Collections.reverse(lineup);
        isAscending = !isAscending;
    }

    /**
     * Checks whether the lineup contains the specified element.
     *
     * @param element the element to check (non-null)
     * @return true if present; false otherwise
     */
    public boolean contains(T element) {
        return lineup.contains(element);
    }

    /**
     * Returns the current number of elements in the lineup.
     *
     * @return size of the lineup (0 to 4)
     */
    public int size() {
        return lineup.size();
    }

    /**
     * Demonstrates usage of all Lineup methods.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        // Instance 1: Integer lineup
        Lineup<Integer> intLineup = new Lineup<>(1, 2, 3, 4);
        System.out.println("Initial (ascending): " + intLineup);
        intLineup.reverseLineup();
        System.out.println("After reverse (descending): " + intLineup);
        intLineup.add(5);
        System.out.println("After attempting to add 5 (full): " + intLineup);
        intLineup.remove(3);
        System.out.println("After removing 3: " + intLineup);
        System.out.println("Contains 2? " + intLineup.contains(2));
        System.out.println("Size: " + intLineup.size());

        // Instance 2: String lineup with a null element in constructor
        Lineup<String> strLineup = new Lineup<>("A", "B", null, "C");
        System.out.println("String lineup (failed init due to null): " + strLineup);
        strLineup.add("X");
        strLineup.add("M");
        System.out.println("After adding X and M (ascending): " + strLineup);
        strLineup.reverseLineup();
        System.out.println("After reverse: " + strLineup);
        System.out.println("Contains Y? " + strLineup.contains("Y"));
        System.out.println("Size: " + strLineup.size());
    }
}
