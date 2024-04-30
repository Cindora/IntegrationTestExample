package com.JointCalculator;

import com.Lab6.Array_pt1;
import com.Lab6.Sorting_pt3;
import com.Lab7.Matrix_pt2;
import com.Lab7.Matrix_pt3;

import java.util.Arrays;

public class Calculator {
    public static void main(String[] args) {

        double[][] matrix = Matrix_pt3.EnterMatrix();

        Matrix_pt3.PrintMatrix(matrix);

        double[] resultArray = CalculateFully(matrix);

        System.out.println("Результат вычисления: " + Arrays.toString(resultArray));
    }

    public static double[] CalculateFully(double[][] matrix){
        // Lab7pt3
        Matrix_pt3.SwapDiagonals(matrix);

        Matrix_pt3.OddRowsEvenElementsToZeros(matrix);
        //

        // Lab7pt2
        double[] NonzeroDoubleArray = Matrix_pt2.FormArrayOfNonzeroElements(matrix);

        int[] NonzeroIntArray = DoubleArrayToIntArray(NonzeroDoubleArray);
        //

        // Lab6pt3
        int[] ModulesOfNegativesInt = Sorting_pt3.FormArrayOfModulesOfNegatives(NonzeroIntArray);

        Sorting_pt3.sortArray(ModulesOfNegativesInt);

        double[] ModulesOfNegativesDouble = IntArrayToDoubleArray(ModulesOfNegativesInt);
        //

        // Lab6pt1
        int lessThanAvg = Array_pt1.NumberOfElementsLessThanAverage(ModulesOfNegativesDouble);

        double [][] pairs = Array_pt1.findElementsDivisibleByThree(ModulesOfNegativesDouble);
        //

        int len = Math.min(lessThanAvg, pairs.length);

        double[] resultArray = new double[len];

        for (int i = 0; i < len; i++) {
            resultArray[i] = pairs[i][0];
        }

        return resultArray;
    }

    /**
     * Превращение массива double[] в int[].
     * @param array2
     * @return
     */
    public static int[] DoubleArrayToIntArray(double[] array2) {
        int[] arr = new int[array2.length];
        for (int i = 0; i < array2.length; i++) {
            arr[i] = (int) Math.round(array2[i]);
        }
        return arr;
    }

    /**
     * Превращение массива int[] в double[].
     * @param array2
     * @return
     */
    public static double[] IntArrayToDoubleArray(int[] array2) {
        double[] arr = new double[array2.length];
        for (int i = 0; i < array2.length; i++) {
            arr[i] = array2[i];
        }
        return arr;
    }
}
