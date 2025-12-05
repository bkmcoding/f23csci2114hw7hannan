import java.util.ArrayList;
import java.util.List;


// Thinking Notes
/*

Issue: Normal sieve of erasthosenes marks out the NON PRIMES and requires
the total number to loop through. The problem requires counting the primes first
since it has no bounds.

Notes: Keep a cache of each prime number to loop through based on the current iteration

*/

// 104743
public class Hannan7 {
    public static void main(String[] args) {
        int goal = 10001;
        ArrayList<Integer> primes = new ArrayList<>();

        primes.add(2);
        int i = 3;

        while (primes.size() < goal) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }

            i += 2;
        }

        System.out.println(primes.get(primes.size() - 1));
    }

    private static boolean isPrime(int n, List<Integer> primes) {
        int max = (int) Math.sqrt(n);

        for (int p : primes) {
            if (p > max) {
                return true; 
            }

            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }
}
