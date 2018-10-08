package number_of_islands;

import java.util.*;

// https://leetcode.com/problems/number-of-islands/description/
class Solution {

    private static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int nIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != '1') continue; // the cell is water or already visited.
                // find a not visited island
                traverseAndMarkAsVisited(grid, row, col);
                nIslands++;
            }
        }

        return nIslands;
    }


    private void traverseAndMarkAsVisited(char[][] grid, int row, int col) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (grid[cell.row][cell.col] != '2') {
                grid[cell.row][cell.col] = '2';
                if (cell.row - 1 >= 0 && grid[cell.row - 1][cell.col] == '1') {
                    queue.add(new Cell(cell.row - 1, cell.col));
                }
                if (cell.row + 1 < grid.length && grid[cell.row + 1][cell.col] == '1') {
                    queue.add(new Cell(cell.row + 1, cell.col));
                }
                if (cell.col - 1 >= 0 && grid[cell.row][cell.col - 1] == '1') {
                    queue.add(new Cell(cell.row, cell.col - 1));
                }
                if (cell.col + 1 < grid[0].length && grid[cell.row][cell.col + 1] == '1') {
                    queue.add(new Cell(cell.row, cell.col + 1));
                }
            }
        }
    }

}
