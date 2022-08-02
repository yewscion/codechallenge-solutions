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
        int currentValue = 0;
        
        for (final int number : array) {
            currentValue = number;
            if (currentValue > 0 && currentValue >= max) {
                max = currentValue;
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
        else if (myArray[index] <= 0) {
            return -1;
        }
        else
            return largestValueIndex(indicesWithinSteps(index));
    }

    private int[] makeMinimumChain() {
        final ArrayList<Integer> staging = new ArrayList<Integer>();
        int index = 0;

        while (index >= 0 && index < goalIndex) {
            staging.add(index);
            index = nextIndex(index);
            if (index == -1)
                return new int[] { -1 };
        }
        staging.add(goalIndex);
        
        final int result[] = arraylistIntToIntArray(staging);
        return result;
    }

    private String buildOutput() {
        // Expected Format: 3 (1-> 3 -> 9 -> 9)
        if (Arrays.binarySearch(minimumChain, -1) >= 0)
            return "-1 (\u22A5)";
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
