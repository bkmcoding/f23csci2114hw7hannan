import java.math.BigInteger;

// 1366
public class Hannan16 {
    public static void main(String[] args) {
        BigInteger bigNum = new BigInteger("2");
        for (int i = 1; i < 1000; i++) {
            bigNum = bigNum.multiply(new BigInteger("2"));
        }

        String str = bigNum.toString();
        int total = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int val = Integer.parseInt(String.valueOf(c));
            total = total + val;
        }
        System.out.println(total);
    }
}
