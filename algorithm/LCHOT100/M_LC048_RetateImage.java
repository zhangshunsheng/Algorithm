package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: M_LC048_RetateImage
 * Description:
 * date: 2022/7/28 16:48
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC048_RetateImage {
    /**
     * 计算坐标变换
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for( int i = 0; i < length - 1; i++ ) {
            for(int j = i; j < matrix[i].length - 1 - i; j++) {
                int temp = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * 旋转变换
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int arrayLength = (matrix.length + 1) >>> 1;
        for( int i = 0; i < arrayLength; i++ ) {
            for(int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
        for( int i = 0; i < matrix.length; i++ ) {
            for(int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
