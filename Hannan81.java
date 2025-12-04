/*
 * In the by matrix below, the minimal path sum from the top left to the bottom right, by only moving to the right and down,
 *  is indicated in bold red and is equal to 2427
 *
 *Find the minimal path sum from the top left to the bottom right by only moving right and down in matrix.txt 
 *(right click and "Save Link/Target As..."), a 31K text file containing an by matrix.
 */

// {row, col}
// 427337
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Hannan81 {
    static int[][] pathway;
    static int pathwaySize;
    static int[][] path;

    public static void main(String[] args) {
        pathway = read("0081_matrix.txt");
        pathwaySize = pathway.length;
        path = new int[pathwaySize][pathwaySize];


        for (int[] row : path) Arrays.fill(row, -1);

        int[] startCord = {0, 0};
        System.out.println(getCostFrom(startCord));
    }


    public static int getCostFrom(int[] currentCord) {
        int r = currentCord[0];
        int c = currentCord[1];

        if (r >= pathwaySize || c >= pathwaySize) {
            return Integer.MAX_VALUE;
        }
        if (r == pathwaySize - 1 && c == pathwaySize - 1) {
            return pathway[r][c];
        }
        if (path[r][c] != -1) {
            return path[r][c];
        }

        int[] rightNeighbor = {r, c + 1};
        int[] downNeighbor  = {r + 1, c};
        int costRight = getCostFrom(rightNeighbor);
        int costDown  = getCostFrom(downNeighbor);

        int totalCost = pathway[r][c] + Math.min(costRight, costDown);
        
        path[r][c] = totalCost;
        return totalCost;
    }

    public static int[][] read(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int[][] arr = new int[80][80];

            for (int r = 0; r < 80; r++) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    
                    for (int c = 0; c < 80; c++) {
                        arr[r][c] = Integer.parseInt(parts[c]);
                    }
                }
            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}