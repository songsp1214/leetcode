package com.leetcode.problemset;

public class LC529 {
    int[][] pos = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1 , 1}, {-1, -1}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        char[][] res = board;
        if (board[click[0]][click[1]] == 'M') {
            res[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            updateClickE(board, click[0], click[1], res);
        }

        return res;
    }

    /* 点击 E 时更新地图 */
    public void updateClickE(char[][] board, int x, int y, char[][] res) {
        int countM = findCountM(board, x, y);
        if (countM == 0) {
            res[x][y] = 'B';
            for (int i = 0; i < pos.length; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];
                if (isInRange(board, nx, ny) && res[nx][ny] == 'E') {
                    updateClickE(board, nx, ny, res);
                }
            }
        } else {
            res[x][y] = (char)(countM + '0');
        }
    }

    /* 查找一个点相邻炸弹的个数 */
    public int findCountM(char[][] board, int x, int y) {
        int countM = 0;
        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];
            if (isInRange(board, nx, ny) && board[nx][ny] == 'M') {
                countM++;
            }
        }
        return countM;
    }

    public boolean isInRange(char[][] board, int x, int y) {
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length);
    }
}
