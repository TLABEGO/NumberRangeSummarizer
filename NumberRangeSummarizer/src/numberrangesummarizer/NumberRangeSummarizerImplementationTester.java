package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumberRangeSummarizerImplementationTester {
    public static void main(String[] args) {
        //This method tests the general run of the program
        NumberRangeSummarizerImplementation  implementation = new NumberRangeSummarizerImplementation();
        System.out.println(implementation.summarizeCollection(implementation.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31")));
    }

    /**
     * Unit test for the collect method
     * The test checks if the collect method returns a collection of Integers sorted
     */
    @Test
    public void testCollect() {
        //Raw input string
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        NumberRangeSummarizerImplementation implementation = new NumberRangeSummarizerImplementation();
        ArrayList<Integer> integers = (ArrayList<Integer>) implementation.collect(input);
        assertEquals(3, (int)integers.get(1));
    }

    /**
     * Unit test for summarizeCollection method
     * the method check to see if the returned string from the method is the correct expected output
     */
    @Test
    public void testSummarizeCollection() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        NumberRangeSummarizerImplementation implementation = new NumberRangeSummarizerImplementation();
        ArrayList<Integer> integers = (ArrayList<Integer>) implementation.collect(input);
        assertEquals( "1, 3, 6-8, 12-15, 21-24, 31", implementation.summarizeCollection(integers));
    }

}
