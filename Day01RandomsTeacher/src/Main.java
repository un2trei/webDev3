import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
// THIS DOES NOT WORK
public class Main {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
try {
    System.out.println("How many numbers do you want to generate? ");
    int count = input.nextInt();
    input.nextLine(); //consume the leftover new line IMPORTANT when mix nextInt with nextLine etc.
    if (count < 0) {
        System.out.println("ERROR: number must be a positive integer");
        return;
    }
    System.out.print("what is your name ");
    String name = input.nextLine();

    if (name.equals("")) {
        System.out.println("ERROR: name must not be empty");
        return;
    }
    System.out.println("please provide the minimum:");
    int min = input.nextInt();
    input.nextLine();

    System.out.println("please provide the maximum:");
    int max = input.nextInt();
    input.nextLine();
    int range = max - min + 1;
    for (int i = 0; i < count; i++) {
        int num = random.nextInt(range) + min;
        System.out.printf("Random number #%d is %d\n", i + 1, num);
//        System.out.println("random number #" + (i + 1) + "is " + num);
    }
} catch (InputMismatchException ex) {
    System.out.println("ERROR: input was not an integer value or was out of range");
    return;
}

    }
}