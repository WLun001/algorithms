package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * bunny in even number standing lines have 3 ears(raised one leg)
 * bunny in odd number standing lines have 2 ears
 */

public class BunnyEars {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter bunny line: ");
            int m = input.nextInt();
            System.out.println("bunny ears: " + bunny_ears(m));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, expecting and integer");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static int bunny_ears(int standingLine) {
        if (standingLine < 0) throw new IllegalArgumentException("Only positive integer is allowed");
        int earCount = 0;
        if (standingLine == 0) return 0;
//        else if (standingLine == 1) return 2;
        else if (standingLine % 2 == 0) {
            earCount = earCount + 3 + bunny_ears(standingLine - 1);
        } else {
            earCount = earCount + 2 + bunny_ears(standingLine - 1);
        }
        return earCount;
    }
}
