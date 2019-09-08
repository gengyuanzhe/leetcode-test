package learning.leetcode;

public class Q0289GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = getNextStatus(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = getCurrentStatus(board[i][j]);
            }
        }
    }

    // 用二进制的高位保存下一个状态
    int getNextStatus(int[][] board, int x, int y) {
        int aliveCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 && j == 0) || x + i < 0 || x + i >= board.length || y + j < 0 || y + j >= board[0].length) {
                    continue;
                }

                if (getPreviousStatus(board[x + i][y + j]) == 1) {
                    aliveCount++;
                }
            }
        }
        if (aliveCount == 3 || aliveCount == 2 && getPreviousStatus(board[x][y]) == 1) {
            return board[x][y] + 2;
        }
        return board[x][y];
    }

    int getPreviousStatus(int x) {
        return x % 2;
    }

    int getCurrentStatus(int x) {
        return x / 2;
    }
}
