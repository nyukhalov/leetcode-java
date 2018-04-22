package flood_fill;

import java.util.*;

// https://leetcode.com/problems/flood-fill/description/
class Solution {
    static class Point {
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public int r;
        public int c;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Point> toVisit = new LinkedList<>();
        int curColor = image[sr][sc];
        if (curColor != newColor) {
            toVisit.add(new Point(sr, sc));
            while (!toVisit.isEmpty()) {
                Point p = toVisit.poll();
                if (image[p.r][p.c] != curColor) continue;
                image[p.r][p.c] = newColor;

                if (p.r - 1 >= 0 && image[p.r - 1][p.c] == curColor) toVisit.add(new Point(p.r - 1, p.c));
                if (p.r + 1 < image.length && image[p.r + 1][p.c] == curColor) toVisit.add(new Point(p.r + 1, p.c));
                if (p.c - 1 >= 0 && image[p.r][p.c - 1] == curColor) toVisit.add(new Point(p.r, p.c - 1));
                if (p.c + 1 < image[0].length && image[p.r][p.c + 1] == curColor) toVisit.add(new Point(p.r, p.c + 1));
            }
        }
        return image;
    }
}
