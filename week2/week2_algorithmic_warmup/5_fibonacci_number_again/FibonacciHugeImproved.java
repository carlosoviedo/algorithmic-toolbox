import java.util.*;
import java.math.BigInteger;

public class FibonacciHugeImproved {
    private static long getFibonacciHugeImproved(long n, long m) {
        if (n <= 1)
            return n;

        final long[] pisanoPeriod = createPisanoPeriod(n, m);
        return pisanoPeriod[(int)(n % pisanoPeriod.length)];
    }

    private static long[] createPisanoPeriod(final long n, final long m) {
        final List<Long> pisanoPeriod = new LinkedList<>();
        pisanoPeriod.add(0l);
        pisanoPeriod.add(1l);

        BigInteger previous = BigInteger.valueOf(0);
        BigInteger current  = BigInteger.valueOf(1);
        boolean periodComplete = false;

        for (long i = 0; i < n - 1; ++i) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
            periodComplete = previous.equals(BigInteger.valueOf(0)) && current.equals(BigInteger.valueOf(1));
            
            if (!periodComplete) {
                if ((i + 1) % 2 == 0) {
                    pisanoPeriod.add(previous.mod(BigInteger.valueOf(m)).longValue());
                    pisanoPeriod.add(current.mod(BigInteger.valueOf(m)).longValue());
                } else if (i == n - 2) {
                    pisanoPeriod.add(current.mod(BigInteger.valueOf(m)).longValue());
                }
            } else {
                break;
            }
        }
        return pisanoPeriod.stream().mapToLong(l -> l).toArray();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeImproved(n, m));
    }
}

