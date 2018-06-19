package practice;

import java.util.*;

/**
 * get all the first n Prime number
 */

public class FirstPrimeNumber {

    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter n to get first nth prime number: ");
            int n = input.nextInt();
            System.out.println("List of first " + n + "prime numbers in descending order");
            Arrays.stream(firstPrimeNumbers(n)).forEach(System.out::println);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input, expecting an Integer");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * get the array in reserve order
     * @param count nth of prime number
     * @return array of prime number in descending order
     */
    public static int[] firstPrimeNumbers(int count) {
        ArrayList<Integer> primes = new ArrayList<>();
        primeNumbers(2, primes, count);
        return primes.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }

    /**
     * check all prime number
     * @param n prime number, start from 2
     * @param primes list of prime number
     * @param count count of required nth prime number
     */
    private static void primeNumbers(int n, ArrayList<Integer> primes, int count) {
        if (n < 0) throw new IllegalArgumentException("Only positive integer is allowed");
        if (count != primes.size()) {
            primes(n + 1, Math.ceil(Math.sqrt(n)), primes);
            primeNumbers(n + 1, primes, count);
        }
    }

    /**
     * check if the number if prime number
     * @param x the number
     * @param i sqrt of the number
     * @param primes list of prime number
     * @return
     */
    private static int primes(int x, double i, ArrayList<Integer> primes) {
        if (i == 1)
            primes.add(x);
        if (x % i == 0)
            return 0;
        else
            return primes(x, i - 1, primes);
    }

}
