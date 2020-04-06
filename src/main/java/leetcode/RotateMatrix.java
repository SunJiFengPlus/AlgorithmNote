package leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 *
 * @author 孙继峰
 * @since 2020/4/7
 */
public class RotateMatrix {
    // 先以对角线(↖↘)反转, 再以每行中心反转
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int le = 0, ri = matrix[i].length - 1;
            while (ri > le) {
                int temp = matrix[i][ri];
                matrix[i][ri--] = matrix[i][le];
                matrix[i][le++] = temp;
            }
        }
    }
}
