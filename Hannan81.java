/*
 * In the by matrix below, the minimal path sum from the top left to the bottom right, by only moving to the right and down,
 *  is indicated in bold red and is equal to 2427
 *
 *Find the minimal path sum from the top left to the bottom right by only moving right and down in matrix.txt 
 *(right click and "Save Link/Target As..."), a 31K text file containing an by matrix.
 */

// {row, col}

// UNFINISHED
// &$
public class Hannan81 {
    static int[][] pathway = {
        {131, 673, 234, 103, 18},
        {201, 96,  324, 965, 150},
        {630, 803, 746, 422, 111},
        {537, 699, 497, 121, 956},
        {805, 732, 524, 37,  331}
    };
    static int pathwaySize = pathway.length;

    public static void main(String[] args) {
        int pathCost = pathway[0][0];
        int[] currentCord = {0,0};
        
        int[] endCoord = {pathwaySize - 1,pathwaySize - 1};

        int[][] neighborsIndices = {
            {0,1}, {1,0}
        };

        while (!(currentCord[0] == endCoord[0] && currentCord[1] == endCoord[1])) {
            int[] rightNeighbor = {currentCord[0], currentCord[1] + neighborsIndices[0][1]};
            int[] downNeighbor = {currentCord[0] + neighborsIndices[1][0], currentCord[1]};

            currentCord = getLeastNeighbor(rightNeighbor, downNeighbor);

            pathCost += getPathValue(currentCord);

            // rightNeighborIndex = new int[]{currentCord[0] + neighbors[0][0], currentCord[1] + neighbors[0][1]};
            // downNeighborIndex = new int[]{currentCord[0] + neighbors[1][0], currentCord[1] + neighbors[1][1]};
            // if ((pathway[rightNeighborIndex[1]][rightNeighborIndex[0]]) >= (pathway[downNeighborIndex[1]][rightNeighborIndex[0]])) {
            //     pathCost += pathway[rightNeighborIndex[1]][rightNeighborIndex[0]];
            //     currentCord[0] = rightNeighborIndex[0];
            //     currentCord[1] = rightNeighborIndex[1];
            // }
            // else {
            //     pathCost += pathway[downNeighborIndex[1]][downNeighborIndex[0]];
            //     currentCord[0] = downNeighborIndex[0];
            //     currentCord[1] = downNeighborIndex[1];
            // }
            // System.out.println(currentCord[0] + ", " + currentCord[1]);
            System.out.println(pathCost);
        }
        
    }

    public static int[] getLeastNeighbor(int[] neighbor1, int[] neighbor2) {
        // Ensure edge cases are within bounds
        if (!(neighbor1[1] < pathwaySize)) {
            return neighbor2;
        } 
        if (!(neighbor2[0] < pathwaySize)) {
            return neighbor1;
        }


        if (pathway[neighbor1[0]][neighbor1[1]] >= pathway[neighbor2[0]][neighbor2[1]]) {
            return neighbor2;
        } else {
            return neighbor1;
        }
    }

    public static int getPathValue(int[] node) {
        // System.out.println(node[0]);
        // System.out.println(pathway[node[0]][node[1]]);
        return (pathway[node[0]][node[1]]);
    }
}
