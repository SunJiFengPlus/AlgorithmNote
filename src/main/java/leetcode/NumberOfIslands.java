package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author 孙继峰
 * @since 2020/4/20
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    res++;
                    dfs(grid, column, row);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int column, int row) {
        int boardRow = grid.length, boardColumn = grid[0].length;
        if (column < 0 || column > boardColumn - 1 || row < 0 || row > boardRow - 1 || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        dfs(grid, column, row - 1);
        dfs(grid, column, row + 1);
        dfs(grid, column - 1, row);
        dfs(grid, column + 1, row);
    }

    @Test
    public void test1() {
        char[][] input = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        Assert.assertEquals(numIslands(input), 1);
    }
}
