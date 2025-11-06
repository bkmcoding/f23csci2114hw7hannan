

public class Hannan66 {
    public static void main(String[] args) {
        int currD = 1;
        int x = 2;
        int y = 2;
        int maxD = currD;
        while (currD <= 1000) {
            while(!checkDiophantine(x,y,currD)) {
                y++;
                if (squared(x) < currD * squared(y)) {

                }
            }
        }
    }

    public static boolean checkDiophantine(double x, int y, int D) {
        return (Math.pow(x, 2) - (D * Math.pow(y, 2)) == 1);
    }

    public static int squared(int n) {
        return (int)Math.pow(n, 2);
    }
}
