package com.Lab6;
import java.util.Scanner;

public class Array_pt1 {
    public static void main(String[] args) {
        double[] Xn = EnterArray();

        System.out.println("Количество элементов массива, меньших среднего: " +
                NumberOfElementsLessThanAverage(Xn));

        // Значения и номера элементов, делящихся на 3
        System.out.println("Элементы, делящиеся на 3 без остатка:");
        for (double[] pair : findElementsDivisibleByThree(Xn)) {
            System.out.println("Значение: " + pair[0] + ", Позиция: " + ((int)pair[1]+1));
        }
        //
    }

    /**
     * Ввод массива.
     * @return
     */
    public static double[] EnterArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.print("Ошибка ввода размера массива (N > 0) ");
            n = scanner.nextInt();
        }
        double[] arr = new double[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextDouble();
        }

        return arr;
    }

    /**
     * Вычисление числа элементов массива меньше его среднего значения.
     * @param arr
     * @return int
     */
    public static int NumberOfElementsLessThanAverage(double[] arr){
        int countLessThanAvg = 0;

        if (arr.length != 0) {
            double sum = 0;
            for (double el : arr) {
                sum += el;
            }
            double avg = sum / arr.length;


            for (double el : arr) {
                if (el < avg) {
                    countLessThanAvg++;
                }
            }
        }
        return countLessThanAvg;
    }

    /**
     * Поиск элементов делящихся на 3 и их позиций.
     * @param array
     * @return
     */
    public static double[][] findElementsDivisibleByThree(double[] array) {
        int count = 0;

        // Определяем количество элементов, делящихся на 3 без остатка
        for (double element : array) {
            if (element % 3 == 0) {
                count++;
            }
        }

        // Создаем двумерный массив для хранения пар (значение, позиция)
        double[][] resultArray = new double[count][2];
        int index = 0;

        // Заполняем двумерный массив
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                resultArray[index][0] = array[i]; // Значение
                resultArray[index][1] = i;        // Позиция
                index++;
            }
        }

        return resultArray;
        }
}
