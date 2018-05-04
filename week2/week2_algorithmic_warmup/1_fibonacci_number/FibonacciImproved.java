import java.util.Scanner;

public class FibonacciImproved {
  private static long calc_fib(int n) {
    if (n < 2) {
      return n;
    }

    final long[] cache = new long[n+1];
    cache[0] = 0;
    cache[1] = 1;
    for (int i = 2; i <= n; i++) {
      cache[i] = cache[i - 1] + cache[i - 2];
    }
    return cache[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
