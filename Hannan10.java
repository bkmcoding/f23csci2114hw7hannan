
// 142913828922
public class Hannan10 {
    public static void main(String[] args) {
        System.out.println(eratosthenes(2_000_001));
    }

    public static long eratosthenes(int num) {
        boolean[] numbers = new boolean[num];
        long sum = 0;

        for (int i = 2; i < Math.sqrt(numbers.length); i++) {
            if (!numbers[i]) {
                for (int j = i * i; j < numbers.length; j+=i) {
                    numbers[j] = true;
                }
            }
        }

        for (int i = 2; i < numbers.length; i++) {
            if (!numbers[i]) {
                sum += i;
            }
        }

        return sum;

    }
}
