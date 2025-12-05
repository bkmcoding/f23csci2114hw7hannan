import java.math.BigInteger;

// 4075
public class Hannan53 {
    public static void main(String[] args) {
        int count = 0;
        BigInteger milly = new BigInteger("1000000");
        
        for (int n = 1; n < 101; n++) {
            for (int r = 1; r < n + 1; r++) {
                BigInteger top = factorial(n);
                BigInteger bottom = factorial(r).multiply(factorial(n - r));
                BigInteger combinations = top.divide(bottom);
                if (combinations.compareTo(milly) > 0)
                    count++;
            }
        }

        System.out.println(count);
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
