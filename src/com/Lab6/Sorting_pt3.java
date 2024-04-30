package com.Lab6;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_pt3 {
    public static void main(String[] args) {
        int[] Xn = EnterArray();

        int[] Zn = FormArrayOfModulesOfNegatives(Xn);

        sortArray(Zn);

        System.out.println("Отсортированный массив Zn: " + Arrays.toString(Zn));
    }

    /**
     * Ввод массива.
     * @return
     */
    public static int[] EnterArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.print("Ошибка ввода размера массива (N > 0) ");
            n = scanner.nextInt();
        }
        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        return arr;
    }

    /**
     * Формирование массива, состоящего из
     * модулей отрицательных элементов исходного массива
     * @param arr
     * @return
     */
    public static int[] FormArrayOfModulesOfNegatives(int[] arr){
        int [] Zn = new int[arr.length];
        int newN = 0;
        for (int el : arr) {
            if (el < 0) {
                Zn[newN] = Math.abs(el);
                newN++;
            }
        }
        Zn = Arrays.copyOf(Zn, newN);
        return Zn;
    }

    /**
     * Сортировка массива по убыванию.
     * @param arr
     */
    public static void sortArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Находим максимальный элемент в оставшейся части массива
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Меняем местами текущий элемент и максимальный элемент
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
}
