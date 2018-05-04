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

        long previous = 0;
        long current  = 1;
        boolean periodComplete = false;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous % m;
            previous = current % m;
            current = (tmp_previous + current) % m;
            periodComplete = previous == 0 && current == 1;
            
            if (periodComplete) {
                break;
            }
            pisanoPeriod.add(previous);
        }

        if (!periodComplete) {
            pisanoPeriod.add(current);
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

