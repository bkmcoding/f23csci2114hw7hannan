

// 232792560
public class Hannan5 {
    public static void main(String[] args) {
        int i = 20;
        while (true) {
            boolean passed = true;

            for (int divisor = 2; divisor <= 20; divisor++) {
                if (i % divisor != 0) {
                    passed = false;
                    break;
                }
            }

            if (passed) {
                System.out.println(i);
                break;
            }
            i += 20;
        }
    }
}
