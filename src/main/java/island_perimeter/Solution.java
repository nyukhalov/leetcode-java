package island_perimeter;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int nrOfLandCells = 0, nrOfOverlapping = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    nrOfLandCells++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) nrOfOverlapping++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) nrOfOverlapping++;
                }
            }
        }

        return nrOfLandCells * 4 - nrOfOverlapping * 2;
    }
}