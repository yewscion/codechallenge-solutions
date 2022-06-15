// Minimum number of jumps to reach end
// Source: https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
// Retrieved: 2022-06-13

// Difficulty: 4

// Given an array of integers where each element represents the max number of steps
// that can be made forward from that element. Write a function to return the
// minimum number of jumps to reach the end of the array (starting from the first
// element). If an element is 0, they cannot move through that element. If the end
// isn’t reachable, return -1.

// Examples: 

// Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output: 3 (1-> 3 -> 9 -> 9)

// Explanation: Jump from 1st element to 2nd element as there is only 1 step, now
// there are three options 5, 8 or 9.  If 8 or 9 is chosen then the end node 9 can
// be reached. So 3 jumps are made.

// Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
// Output: 10

// Explanation: In every step a jump is needed so the count of jumps is 10.

// The first element is 1, so can only go to 3. The second element is 3, so can
// make at most 3 steps eg to 5 or 8 or 9.

package codechallenges.minimumjumps;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class minimumJumps {
    // Fields
    private final boolean strictness;
    private final int myArray[];
    private final int goalIndex;
    private final boolean adjacencyMatrix[][];
    private final int minimumChain[];
    private final String output;
    // Methods
    private int indexToSteps(int index) {
        if (index >= goalIndex - 1)
            return -1;
        else
            return myArray[index];
    }
    private int[] indicesWithinSteps(int index) {
        int steps = indexToSteps(index);
        int result[];
        if (steps < 0)
            return new int[] { -1 };
        ArrayList<Integer> staging = new ArrayList<Integer>();
        for (int i = index + 1; i < steps + index + 1 && i < goalIndex; i++) {
            staging.add(i);
        }
        result = staging.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        Arrays.sort(result);
        return result;
    }
        
    private int[] valuesWithinSteps(int index) {
        int steps = indexToSteps(index);
        if (steps < 0 || index == goalIndex)
            return new int[] { 0 };
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = index + 1; i < steps + index + 1 && i < goalIndex; i++) {
            result.add(myArray[i]);
        }
        return result.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
    private void printArray() {
        System.out.print("Array: ");
        for (int number : myArray) {
            System.out.print(number + " ");
        }
        System.out.print("\n");
    }
    private void printGoal() {
        System.out.print("Goal: " + goalIndex + "\n");
    }
    private void printStrictness() {
        if (strictness) {
            System.out.println("We are applying the rules strictly.");
        }
        else {
            System.out.println("We are not applying the rules strictly.");
        }
    }
    private void printValueArrays() {
        for (int i = 0;i < goalIndex;i++) {
            System.out.print("Index: " + i + " Value: " + myArray[i] + " Indices Visible: ");
            for (int number : indicesWithinSteps(i)) {
                System.out.print("[" + number + "]");
            }
            System.out.print("  Values Visible: ");
            for (int number : valuesWithinSteps(i)) {
                System.out.print("[" + number + "]");
            }
            System.out.print("\n");
        }
    }
    private boolean[][] makeAdjacencyMatrix(int array[]) {
        boolean[][] result = new boolean[array.length][array.length];
        for (int i=0;i<array.length;i++) {
            for (int j=0;j<array.length;j++) {
                if(Arrays.binarySearch(indicesWithinSteps(i),j) >= 0)
                    result[i][j] = true;
                else
                    result[i][j] = false;
            }
        }
        return result;
    }

    private void printAdjacencyMatrix() {
        for (int i=0;i<myArray.length;i++) {
            for (int j=0;j<myArray.length;j++) {
                if (adjacencyMatrix[i][j])
                    System.out.print("O ");
                else
                    System.out.print("X ");
            }
            System.out.print("\n");
        }
    }

    private int largestValueIndex(int array[]) {
        int result = -1;
        int index = 0;
        int max = 0;
        
        for (int number : array) {
            // System.out.print("DEBUG: " + number + " " + result + " " + index + " " + max + "\n");
            if (number > max) {
                max = number;
                result = index;
            }
            index++;
            // System.out.print("DEBUG: " + number + " " + result + " " + index + " " + max + "\n");

        }
        // System.out.print("DEBUG: " + result + " " + index + " " + max + "\n");

        if (result == -1)
            return -1;
        else
            return array[result];
    }

    private int nextIndex(int index) {
        return largestValueIndex(indicesWithinSteps(index));
    }

    private int[] makeMinimumChain() {
        ArrayList<Integer> staging = new ArrayList<Integer>();
        int index = 0;

        while (index >= 0) {
            staging.add(index);
            index = nextIndex(index);
        }
        
        int result[] = staging.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        return result;
    }

    private void printMinimumChain() {
        for (int number : makeMinimumChain())
            System.out.print(number + " ");
        System.out.print("\n");
    }

    private String buildOutput() {
        // Expected Format: 3 (1-> 3 -> 9 -> 9)
        StringBuilder result = new StringBuilder();
        int numberOfJumps = minimumChain.length - 1;
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
        
    public minimumJumps(int array[], boolean strict) {
        strictness = strict;
        myArray = array;
        goalIndex = myArray.length;
        adjacencyMatrix = makeAdjacencyMatrix(myArray);
        minimumChain = makeMinimumChain();
        output = buildOutput();
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> staging = new ArrayList<Integer>();
        int input[];
        String raw[] = scanner.nextLine().split(" +");
        scanner.close();
        for (String i : raw) {
            staging.add(Integer.parseInt(i));
        }
        
        input = staging.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        
        minimumJumps test = new minimumJumps(input, false);
        test.printOutput();
    }
}
