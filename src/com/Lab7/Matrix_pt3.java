package com.Lab7;
import java.util.Scanner;

public class Matrix_pt3 {
    public static void main(String[] args) {

        double[][] matrix = EnterMatrix();

        PrintMatrix(matrix);

        SwapDiagonals(matrix);

        OddRowsEvenElementsToZeros(matrix);

        PrintMatrix(matrix);
    }

    /**
     * Ввод матрицы.
     * @return
     */
    public static double[][] EnterMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер квадратной матрицы: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.print("Ошибка ввода размера матрицы.\n" +
                    "Введите размер квадратной матрицы (N > 0): ");
            n = scanner.nextInt();
        }

        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите " + i + " строку матрицы: ");

            for (int j = 0; j < n; j++) {
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
        System.out.println("Матрица:");

        for (double[] row : matrix) {
            for (double el : row) {
                System.out.printf("%6.2f; ", el);
            }
            System.out.println();
        }
    }

    /**
     * Меняем местами главную и второстепенную диагонали.
     * @param matrix
     */
    public static void SwapDiagonals(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            double temp = matrix[i][i];
            matrix[i][i] = matrix[i][n-1-i];
            matrix[i][n-1-i] = temp;
        }
    }

    /**
     * Заменяем все четные элементы, стоящие в нечетных строках, нулями.
     * @param matrix
     */
    public static void OddRowsEvenElementsToZeros (double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] % 2 == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}

