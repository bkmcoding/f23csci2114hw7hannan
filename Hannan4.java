

// 906609
public class Hannan4 {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        int greatest = 0;

        for (int i = 999; i > 100; i--) {
            for (int j = 999; j > 100; j--) {
                a.setLength(0);
                a.append(i * j);
                int aInt = Integer.parseInt(a.toString());
                if (checkReverse(a) && (aInt > greatest)) {
                    greatest = aInt;
                }
            }
        }
        System.out.println(greatest);
    }

    private static boolean checkReverse(StringBuilder n) {
        // System.out.println(n.toString());
        // System.out.println("ORIGINAL: " + n.toString());
        // System.out.println("REVERSED: " + n.reverse().toString());
        if (n.toString().equals(n.reverse().toString())) {
            // System.out.println(n);
            return true; 
        }
        else return false;
    }
}
