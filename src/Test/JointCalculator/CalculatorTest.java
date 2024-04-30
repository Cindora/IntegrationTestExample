package Test.JointCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.JointCalculator.Calculator;

class CalculatorTest {

    double[][] matrix;

    @BeforeEach
    void setUp() {
        matrix = new double[][]
                {{-5, 0, -27, 19, 33},
                {-4, 4, -36, 0, 7.7, 3},
                {-12, -7.77, - 999, 3, 0},
                {47, -15, 0, -37, -12},
                {-1, 111.3, 333, -333, -96}};
    }

    @Test
    void calculateFullyTest() {
        double[] expectedResult = new double[] {999.0, 96.0, 27.0, 12.0};

        double[] resultOfCalculation = Calculator.CalculateFully(matrix);

        assertArrayEquals(expectedResult, resultOfCalculation);
    }
}