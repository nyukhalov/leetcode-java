package max_area_of_island;

import java.util.*;

// https://leetcode.com/problems/max-area-of-island/description/
class Solution {
    private static int WATER = 0;
    private static int ISLAND = 1;
    private static int VISITED = 2;

    static class Point {
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public int row;
        public int col;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                new int[] {1,1,0,0,0},
                new int[] {1,1,0,0,0},
                new int[] {0,0,0,1,1},
                new int[] {0,0,0,1,1}
        };
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Point islandPoint = new Point(0, 0);
        while ((islandPoint = findNextPoint(grid, islandPoint)) != null) {
            int area = traverseAnIsland(grid, islandPoint);
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }

    // searches top to bottom, left to right
    private Point findNextPoint(int[][] grid, Point lastPoint) {
        int row = lastPoint.row;
        int col = lastPoint.col;

        for (int r = row; r<grid.length; r++) {
            for (int c = 0; c<grid[0].length; c++) {
                if (r == row && c == 0) c = col;
                if (grid[r][c] == ISLAND) {
                    return new Point(r, c);
                }
            }
        }
        return null;
    }

    private int traverseAnIsland(int[][] grid, Point islandPoint) {
        Queue<Point> toVisit = new LinkedList<>();
        toVisit.add(islandPoint);
        int area = 0;
        while(!toVisit.isEmpty()) {
            Point p = toVisit.poll();
            if (grid[p.row][p.col] == VISITED) continue;
            area++;
            grid[p.row][p.col] = VISITED;
            if (p.row - 1 >= 0 && grid[p.row - 1][p.col] == ISLAND) toVisit.add(new Point(p.row - 1, p.col));
            if (p.row + 1 < grid.length && grid[p.row + 1][p.col] == ISLAND) toVisit.add(new Point(p.row + 1, p.col));
            if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == ISLAND) toVisit.add(new Point(p.row, p.col - 1));
            if (p.col + 1 < grid[0].length && grid[p.row][p.col + 1] == ISLAND) toVisit.add(new Point(p.row, p.col + 1));
        }
        return area;
    }
}
