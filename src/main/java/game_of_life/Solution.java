package game_of_life;

// https://leetcode.com/problems/game-of-life/
class Solution {
    public void gameOfLife(int[][] board) {
        // evaluation next state
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                int state = evaluateState(board, r, c); // returns 1 or 0
                if (state > 0) {
                    board[r][c] |= (state << 1);
                }
            }
        }

        // overriding the current state
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                board[r][c] = board[r][c] >>> 1;
            }
        }
    }

    private int evaluateState(int[][] board, int r, int c) {
        boolean isAlive = (board[r][c] & 1) > 0;
        int nNeighbours = findNumbersOfNeighbours(board, r, c);
        int state = 0;
        if (isAlive) {
            if (nNeighbours == 2 || nNeighbours == 3) {
                state = 1;
            }
        } else if (nNeighbours == 3) {
            state = 1;
        }
        return state;
    }

    private int findNumbersOfNeighbours(int[][] board, int r, int c) {
        int ret = 0;
        int[][] poss = new int[][] {
                new int[] {1, 0},
                new int[] {1, 1},
                new int[] {0, 1},
                new int[] {-1, 1},
                new int[] {-1, 0},
                new int[] {-1, -1},
                new int[] {0, -1},
                new int[] {1, -1}
        };
        for (int[] pos: poss) {
            int nr = r + pos[0];
            int nc = c + pos[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if ((board[nr][nc] & 1) > 0) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
