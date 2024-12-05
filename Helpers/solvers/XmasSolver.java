package Helpers.solvers;

public class XmasSolver {

    private static final int[][] DIRECTIONS = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public static int countXmas(char[][] grid, String targetWord) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] dir : DIRECTIONS) {
                    if (isWordFoundInDirection(grid, row, col, dir[0], dir[1], targetWord)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean isWordFoundInDirection(char[][] grid, int row, int col, int rowStep, int colStep, String targetWord) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < targetWord.length(); i++) {
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != targetWord.charAt(i)) {
                return false;
            }
            row += rowStep;
            col += colStep;
        }
        return true;
    }

    public static int countMASInXPatterns(String[] grid, int rows, int cols) {
        int count = 0;

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r].charAt(c) == 'A') {
                    char topLeft = grid[r - 1].charAt(c - 1);
                    char topRight = grid[r - 1].charAt(c + 1);
                    char bottomLeft = grid[r + 1].charAt(c - 1);
                    char bottomRight = grid[r + 1].charAt(c + 1);

                    if (isMASPattern(topLeft, topRight, bottomLeft, bottomRight)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isMASPattern(char topLeft, char topRight, char bottomLeft, char bottomRight) {
        return (topLeft == 'M' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'S') ||
               (topLeft == 'S' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'M') ||
               (topLeft == 'M' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'S') ||
               (topLeft == 'S' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'M');
    }
}
