import java.util.*;

public class GCDImproved {
  private static int gcd_euclidean(int a, int b) {
    int r;
    while (b > 0) {
      r = a % b;
      if (r == b) {
        b = b % a;
      } else {
        a = b;
        b = r;
      }
    }
    return a;    
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_euclidean(a, b));
  }
}
