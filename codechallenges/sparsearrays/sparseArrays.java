package codechallenges.sparsearrays;
import java.util.ArrayList;
import java.util.Scanner;


public class sparseArrays {
    public static void main(String args[]) {
        // begin Program.
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String rawInput;
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String> queries = new ArrayList<String>();
        ArrayList<Integer> results = new ArrayList<Integer>();
        int inputCounter = 0;
        int result;
        //   read a line from the user,
        //     expecting a number that's !> 1000 and !< 1.
        //   this is how many lines to read as Strings.
        while (inputCounter < 1 || inputCounter > 1000) {
            System.out.print("Number of Strings: ");
            inputCounter = scanner.nextInt();
        }
        //   repeat the following that many times:
        while (strings.size() < inputCounter) {
            //     read a line from the user,
            //       expecting a string from 1 to 20 characters long.
            System.out.print("Input String " + strings.size() + ": ");
            rawInput = scanner.next();
            if (rawInput.length() > 20 || rawInput.length() < 1)
                System.out.println("Input must be between 1 and 20 " +
                                   "characters long!");
            //     append that to the Strings array.
            else
                strings.add(rawInput);
        }
        inputCounter = 0; // Reset Counter for Second Set.
        //   read a line from the user,
        //     expecting a number that's !> 1000 and !< 1.
        //   this is how many lines to read as Queries,
        //     and the count of Results.
        while (inputCounter < 1 || inputCounter > 1000) {
            System.out.print("Number of Queries: ");
            inputCounter = scanner.nextInt();
        }
        //   repeat the following that many times:
        while (queries.size() < inputCounter) {
            //     read a line from the user,
            //       expecting a string from 1 to 20 characters long.
            System.out.print("Input String " + queries.size() + ": ");
            rawInput = scanner.next();
            if (rawInput.length() > 20 || rawInput.length() < 1)
                System.out.println("Input must be between 1 and 20 " +
                                   "characters long!");
            //     append that to the Queries array.
            else
                queries.add(rawInput);
        }
        scanner.close();
        //   for every member of Queries:
        for (String query: queries) {
            //   set Result to 0.
            result = 0;
            //     for every member of Strings:
            for (String string: strings) {
                //       when Strings ≡ Queries:
                if (string.equals(query))
                    //         increment Result by 1.
                    result++;
            }
            //     append Result to Results.
            results.add(result);
        }
        //   for every member of Results:
        for (Integer res: results) {
            //      print Results.
            //      print newline.
            System.out.println(res);
        }
        // end Program.        
    }
}
