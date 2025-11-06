import java.util.ArrayList;
import java.util.List;

public class Hannan76 {
    List<int[]> combinations = new ArrayList<>();
    public static int result = 100;
    public static void main(String[] args) {
        


    }

    public void dfs(int index,List<int[]> current,int total) {
        if (total == result ) {
            combinations.add(current.clone());
            return;
        }
        if (index >= 100 || total > result) {
            return;
        }

        // current[0] = index;
        combinations.add(c)
        dfs(index, current, total + index);
        current
    }
}

class 