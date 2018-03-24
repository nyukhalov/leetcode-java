package island_perimeter;

import java.util.*;

// https://leetcode.com/problems/island-perimeter/description/
public class Solution {
    static class RowCol {
        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int row;
        public int col;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RowCol rowCol = (RowCol) o;
            return row == rowCol.row &&
                    col == rowCol.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][] {
                {1, 1},
                {1, 1}
        };
        int p = s.islandPerimeter(grid);
        System.out.println(p);
    }

    public int islandPerimeter(int[][] grid) {
        RowCol rc = findFirstLandCell(grid);
        return traverseIsland(grid, rc);
    }

    private RowCol findFirstLandCell(int[][] grid) {
        for (int row=0; row < grid.length; row++) {
            for (int col=0; col < grid[row].length; col++) {
                if (isLandCell(grid, row, col)) return new RowCol(row, col);
            }
        }
        throw new IllegalStateException("Impossible");
    }

    private int traverseIsland(int[][] grid, RowCol initialRc) {
        Set<RowCol> visited = new HashSet<>();
        Queue<RowCol> visitNext = new LinkedList<>();

        visitNext.add(initialRc);

        int nrOfLandCells = 0;
        int nrOfLandCellConnections = 0;
        while (!visitNext.isEmpty()) {
            RowCol rc = visitNext.poll();
            if (visited.contains(rc)) continue;
            visited.add(rc);
            nrOfLandCells++;
            for (RowCol neighbour: findNotVisitedNeighbours(grid, visited, rc)) {
                nrOfLandCellConnections++;
                visitNext.add(neighbour);
            }
        }

        return 4 * nrOfLandCells - 2 * nrOfLandCellConnections;
    }

    private List<RowCol> findNotVisitedNeighbours(int[][] grid, Set<RowCol> visited, RowCol rc) {
        List<RowCol> result = new ArrayList<>();
        for (RowCol neighbour: findAllNeighbours(grid, rc)) {
            if (!visited.contains(neighbour)) {
                result.add(neighbour);
            }
        }
        return result;
    }

    private List<RowCol> findAllNeighbours(int[][] grid, RowCol rc) {
        List<RowCol> allNeighbours = new ArrayList<>();

        int row = 0;
        int col = 0;

        // left
        row = rc.row;
        col = rc.col - 1;
        if (isCellWithinGrid(grid, row, col) && isLandCell(grid, row, col)) {
            allNeighbours.add(new RowCol(row, col));
        }

        // top
        row = rc.row - 1;
        col = rc.col;
        if (isCellWithinGrid(grid, row, col) && isLandCell(grid, row, col)) {
            allNeighbours.add(new RowCol(row, col));
        }

        // right
        row = rc.row;
        col = rc.col + 1;
        if (isCellWithinGrid(grid, row, col) && isLandCell(grid, row, col)) {
            allNeighbours.add(new RowCol(row, col));
        }

        // bottom
        row = rc.row + 1;
        col = rc.col;
        if (isCellWithinGrid(grid, row, col) && isLandCell(grid, row, col)) {
            allNeighbours.add(new RowCol(row, col));
        }

        return allNeighbours;
    }

    private boolean isCellWithinGrid(int[][] grid, int row, int col) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }

    private boolean isLandCell(int[][] grid, int row, int col) {
        return grid[row][col] == 1;
    }
}
