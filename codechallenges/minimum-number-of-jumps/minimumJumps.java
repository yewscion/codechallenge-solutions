// Minimum number of jumps to reach end
// Source:
// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
// Retrieved: 2022-06-13

// Difficulty: 4

// Given an array of integers where each element represents the max number of
// steps that can be made forward from that element. Write a function to return
// the minimum number of jumps to reach the end of the array (starting from the
// first element). If an element is 0, they cannot move through that element. If
// the end isn’t reachable, return -1.

// Examples: 

// Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output: 3 (1-> 3 -> 9 -> 9)

// Explanation: Jump from 1st element to 2nd element as there is only 1 step,
// now there are three options 5, 8 or 9.  If 8 or 9 is chosen then the end node
// 9 can be reached. So 3 jumps are made.

// Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
// Output: 10

// Explanation: In every step a jump is needed so the count of jumps is 10.

// The first element is 1, so can only go to 3. The second element is 3, so can
// make at most 3 steps eg to 5 or 8 or 9.

package codechallenges.minimumjumps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class minimumJumps {
    // Fields
    private final int myArray[];
    private final int goalIndex;
    private final int minimumChain[];
    private final String output;
    // Methods
    private int indexToSteps(final int index) {
        if (index >= goalIndex - 1)
            return -1;
        else
            return myArray[index];
    }

    private int[] indicesWithinSteps(final int index) {
        final int steps = indexToSteps(index);
        int result[];
        if (steps < 0)
            return new int[] { -1 };
        final ArrayList<Integer> staging = new ArrayList<Integer>();
        for (int i = index + 1; i < steps + index + 1 && i < goalIndex; i++) {
            staging.add(i);
        }
        result = arraylistIntToIntArray(staging);
        Arrays.sort(result);
        return result;
    }
        
    private int largestValueIndex(final int array[]) {
        int result = -1;
        int index = 0;
        int max = 0;
        
        for (final int number : array) {
            if (number > 0 && myArray[number] >= max) {
                max = myArray[number];
                result = index;
            }
            index++;
        }
        if (result == -1) {
            return -1;
        }
        else {
            return array[result];
        }
    }

    private int nextIndex(final int index) {
        if (myArray[index] + index >= goalIndex)
            return goalIndex;
        else
            return largestValueIndex(indicesWithinSteps(index));
    }

    private int[] makeMinimumChain() {
        final ArrayList<Integer> staging = new ArrayList<Integer>();
        int index = 0;

        while (index >= 0 && index < goalIndex) {
            staging.add(index);
            index = nextIndex(index);
        }
        staging.add(goalIndex);
        
        final int result[] = arraylistIntToIntArray(staging);
        return result;
    }

    private String buildOutput() {
        // Expected Format: 3 (1-> 3 -> 9 -> 9)
        final StringBuilder result = new StringBuilder();
        final int numberOfJumps = minimumChain.length - 1;
        result.append(numberOfJumps);
        result.append(" (");
        result.append(myArray[0]);
        for (int i = 1; i < minimumChain.length; i++) {
            result.append(" → ");
            result.append(myArray[minimumChain[i]]);
        }
        result.append(")");
        return result.toString();
    }

    public void printOutput() {
        System.out.println(output);
    }
        
    public minimumJumps(final int array[], final boolean strict) {
        myArray = array;
        goalIndex = myArray.length - 1;
        minimumChain = makeMinimumChain();
        output = buildOutput();
    }

    public static int[] arraylistIntToIntArray(final ArrayList<Integer> list) {
        return list
            .stream()
            .filter(i -> i != null)
            .mapToInt(i -> i)
            .toArray();
    }

    
    
    public static void main(final String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Integer> staging = new ArrayList<Integer>();
        int input[];
        final String raw[] = scanner.nextLine().split(" +");
        scanner.close();
        for (final String i : raw) {
            staging.add(Integer.parseInt(i));
        }
        input = arraylistIntToIntArray(staging);
        
        final minimumJumps test = new minimumJumps(input, false);
        test.printOutput();
    }
}
