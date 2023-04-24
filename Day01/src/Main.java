import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ask the user how many random numbers they want to generate.
        System.out.print("How many random integers do you want to generate? ");
        int numRandomInts = scanner.nextInt();

        // If the number is negative display an error message and stop the program.
        if (numRandomInts < 0) {
            System.out.println("Error: Number of random integers must be non-negative.");
            return;
        }

        // Ask for minimum and maximum integer values (both inclusive).
        System.out.print("Enter minimum: ");
        String minString = scanner.next();
        System.out.print("Enter maximum: ");
        String maxString = scanner.next();

        int min, max;
        try {
            // If any of the numbers is not an integer or is not parseable as one display an error message and stop the program.
            min = Integer.parseInt(minString);
            max = Integer.parseInt(maxString);
        } catch (NumberFormatException e) {
            System.out.println("Error: Minimum and maximum must be integers.");
            return;
        }

        // If minimum is larger than maximum display an error message and stop the program.
        if (min > max) {
            System.out.println("Error: Minimum must be less than or equal to maximum.");
            return;
        }

        // Generate the random integer values user requested and display them on a single line, comma-separated.
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numRandomInts; i++) {
            int randomInt = random.nextInt(max - min + 1) + min;
            resultBuilder.append(randomInt);
            if (i < numRandomInts - 1) {
                resultBuilder.append(", ");
            }
        }
        System.out.println("Result: " + resultBuilder.toString());
    }
}
