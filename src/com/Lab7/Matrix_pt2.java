package com.Lab7;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix_pt2 {
    public static void main(String[] args) {

        double[][] matrix = EnterMatrix();

        PrintMatrix(matrix);

        double[] outArray = FormArrayOfNonzeroElements(matrix);

        // Вывод результата

        System.out.println("Массив ненулевых элементов, располагающихся " +
                "в четных столбцах матрицы:\n" + Arrays.toString(outArray));
    }

    /**
     * Ввод матрицы.
     * @return
     */
    public static double[][] EnterMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число строк и столбцов матрицы: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        while (n <= 0 || m <= 0) {
            System.out.print("Ошибка ввода размера матрицы.\n" +
                    "Введите число строк и столбцов матрицы (N, M > 0): ");
            n = scanner.nextInt();
            m = scanner.nextInt();
        }

        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите " + i + " строку матрицы: ");

            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        return matrix;
    }

    /**
     * Вывод матрицы в консоль.
     * @param matrix
     */
    public static void PrintMatrix(double[][] matrix){
        for (double[] row : matrix) {
            for (double el : row) {
                System.out.printf("%6.2f; ", el);
            }
            System.out.println();
        }
    }

    /**
     * Формирование массива из ненулевых элементов в четных столбцах матрицы.
     * @param matrix
     * @return
     */
    public static double[] FormArrayOfNonzeroElements(double[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;
        double[] outArray = new double[n*m/2];

        for (double[] row : matrix) {
            for (int j = 0; j < m; j++) {
                if (j % 2 == 0 && row[j] != 0) {
                    outArray[count] = row[j];
                    count++;
                }
            }
        }
        outArray = Arrays.copyOf(outArray, count);

        return outArray;
    }

}
