
// This took me way too long.

// 4613732
public class Hannan2 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(4_000_001));
    }

    public static int Fibonacci(int lim) {
        int sum = 0;
        int left = 0;
        int right = 1;
        int answer = 0;

        // for (int i = lim; i > 0; i--) {
        while (left < lim) {
            answer = left + right;
            left = right;
            right = answer;
            if (left % 2 == 0)
                sum += left;
        }
        return sum;
    }
}
