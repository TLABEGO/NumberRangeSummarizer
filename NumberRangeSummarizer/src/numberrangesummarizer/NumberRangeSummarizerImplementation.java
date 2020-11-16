package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {
    /**
     * Implementation of the collect method.
     * @param input string of integers separated by commas
     * @return ArrayList of Integers
     */
    @Override
    public Collection<Integer> collect(String input) {
        //Create collection of integers
        Collection<Integer> integers = new ArrayList<>();
        //Split the input string at (,) delimiter
        String []list = input.split(",");
        //Add each integer into the collection
        for (String s: list) {
            integers.add(Integer.parseInt(s));
        }
        //Sort the collection
        Collections.sort((List<Integer>) integers);
        return integers;
    }

    /**
     * Implementation of summarizeCollection method
     * @param input collection of integers
     * @return string of summarized integers
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        //Initialize variable to hold the output
        String output = "";
        //Initialize variables for previous, current, range start and range end
        int prev , cur, start = ((List<Integer>)input).get(0), end = ((List<Integer>)input).get(0);
        output += start;

        //Iterate the collection
        for (int i=0; i<input.size(); i++) {
            //Set current
            cur = ((List<Integer>)input).get(i);
            //Set previous
            if(i != 0) {
                prev = ((List<Integer>)input).get(i-1);
            }else {
                prev = ((List<Integer>)input).get(i);
            }
            //set start to the current element
            if (i == 0) {
                start = cur;
            }
            //set end of range
                if (cur - prev <= 1) {
                    end = cur;
                } else {
                    //Append comma if the sequence is not range
                    if (start == end) {
                        output+=", ";
                        //if the sequence range ends, append the  - and the ending element
                    }else if(end > start) {
                        output+="-"+end+", ";
                    }else if (start > end) {
                        output+=", ";
                    }
                    //Start  a new range
                    start = cur;
                    output+=start;
                }
        }

        //Return the output
        return output;
    }
}
