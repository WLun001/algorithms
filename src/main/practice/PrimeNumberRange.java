package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * get all the prime number in a given range
 */

public class PrimeNumberRange {

    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter range of number to get prime number: ");
            int n = input.nextInt();
            System.out.println("List of prime numbers in descending order of " + n);
            primeNumbers(n);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input, expecting an Integer");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void primeNumbers(int n) {
        if (n < 0) throw new IllegalArgumentException("Only positive integer is allowed");
        if (n == 0) System.out.println();
        else {
            primes(n - 1, Math.ceil(Math.sqrt(n)));
            primeNumbers(n - 1);
        }
    }

    private static int primes(int x, double i) {
        if (i == 1)
            System.out.println(x);
        if (x % i == 0)
            return 0;
        else
            return primes(x, i - 1);
    }

}
