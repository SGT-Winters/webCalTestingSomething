import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.example.calculator.calculatorLogic;


public class TestCalculatorLogic {
    private calculatorLogic calculatorLogic = new calculatorLogic();

    @Test
    void testStandardDeviation_AddMultipleDoubleValues_ReturnsSampleDeviationOrError(){
        //preq-UNIT-TEST-2

        ArrayList<Double> testNumbers = new ArrayList<>();

        //Valid list of 1 or more samples
        testNumbers.add(9.0);
        testNumbers.add(6.0);
        testNumbers.add(8.0);
        testNumbers.add(5.0);
        testNumbers.add(7.0);
        var result = calculatorLogic.computeSampleDeviation(testNumbers);
        assertEquals("Sample Standard Deviation: 1.5811388300841898", result);

        //List of all zeros
        testNumbers.clear();
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        var result2 = calculatorLogic.computeSampleDeviation(testNumbers);
        assertEquals("Sample Standard Deviation: 0.0", result2);

        //Empty/Null list
        testNumbers.clear();
        var result3 = calculatorLogic.computeSampleDeviation(testNumbers);
        assertEquals("List must contain at least 2 numbers", result3);

    }//end of testComputeSampleDeviation

    @Test
    void testPopulationDeviation_AddMultipleDoubleValues_ReturnsSampleDeviationOrErrorMessage(){
        //preq-UNIT-TEST-3

        ArrayList<Double> testNumbers = new ArrayList<>();

        //List with 1 sample
        testNumbers.add(9.0);
        var errorResult = calculatorLogic.computePopulationDeviation(testNumbers);
        assertEquals("List must contain at least 2 numbers", errorResult);

        //Valid list of 2 or more samples
        testNumbers.clear();
        testNumbers.add(9.0);
        testNumbers.add(6.0);
        testNumbers.add(8.0);
        testNumbers.add(5.0);
        testNumbers.add(7.0);
        var result = calculatorLogic.computePopulationDeviation(testNumbers);
        assertEquals("Population Standard Deviation: 1.4142135623730951", result);

        //List of all zeros
        testNumbers.clear();
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        testNumbers.add(0.0);
        var result2 = calculatorLogic.computePopulationDeviation(testNumbers);
        assertEquals("Population Standard Deviation: 0.0", result2);

        //Empty/Null list
        testNumbers.clear();
        var result3 = calculatorLogic.computePopulationDeviation(testNumbers);
        assertEquals("List must contain at least 2 numbers", result3);

    }//end of computePopulationDeviation

    @Test
    void testMean_AddMultipleDoubleValues_ReturnsMeanOrErrorMessage(){
        //preq-UNIT-TEST-4

        ArrayList<Double> testNumbers = new ArrayList<>();

        //Empty list
        var errorResult = calculatorLogic.getMean(testNumbers);
        assertEquals("List must contain at least 2 numbers", errorResult);

        //Valid list
        testNumbers.clear();
        testNumbers.add(9.0);
        testNumbers.add(6.0);
        testNumbers.add(8.0);
        testNumbers.add(5.0);
        testNumbers.add(7.0);
        var result = calculatorLogic.getMean(testNumbers);
        assertEquals("Mean: 7.0", result);
    }//end of computeMean

    @Test
    void testZScore_AddMultipleDoubleValuesOnOneLine_ReturnsZScoreOrErrorMessage(){
        //preq-UNIT-TEST-5

        ArrayList<Double> testNumbers = new ArrayList<>();

        //Missing one or more parameters
        testNumbers.add(11.5);
        testNumbers.add(7.0);
        var error3Result = calculatorLogic.getZScore(testNumbers);
        assertEquals("List must contain ONLY 3 numbers", error3Result);

        //Valid list of parameters
        testNumbers.clear();
        testNumbers.add(11.5);
        testNumbers.add(7.0);
        testNumbers.add(1.5811388300841898);
        var result = calculatorLogic.getZScore(testNumbers);
        assertEquals("ZScore: 2.846049894151541", result);

        //Mean=0
        testNumbers.clear();
        testNumbers.add(11.5);
        testNumbers.add(0.0);
        testNumbers.add(1.5811388300841898);
        var result2 = calculatorLogic.getZScore(testNumbers);
        assertEquals("ZScore: 7.273238618387272", result2);

        //Divide by 0
        testNumbers.clear();
        testNumbers.add(11.5);
        testNumbers.add(7.0);
        testNumbers.add(0.0);
        var result3 = calculatorLogic.getZScore(testNumbers);
        assertEquals("Standard Deviation Cannot Be Zero", result3);

    }//end of computeMean

    @Test
    void testLinearEquation_AddRowsOfXYPairs_ReturnASingleLinearFormulaOrErrorMessage(){
        //preq-UNIT-TEST-6

        ArrayList<double[]> testSetOfXYPairs = new ArrayList<>();

        //Empty/Null list
        var errorResult = calculatorLogic.calculateLinearEquation(testSetOfXYPairs);
        assertEquals("List must contain at least 2 XY Points", errorResult);

        //All X values are the same
        testSetOfXYPairs.add(new double[]{1,63.11});
        testSetOfXYPairs.add(new double[]{1,64.47});
        testSetOfXYPairs.add(new double[]{1,66.28});
        testSetOfXYPairs.add(new double[]{1,69.1});
        testSetOfXYPairs.add(new double[]{1,69.92});
        testSetOfXYPairs.add(new double[]{1,72.19});
        testSetOfXYPairs.add(new double[]{1,74.46});
        var result = calculatorLogic.calculateLinearEquation(testSetOfXYPairs);
        assertEquals("Error!!! Slope is being divided by zero. Enter new pair of XY pairs", result);

        //All Y values are the same
        testSetOfXYPairs.clear();
        testSetOfXYPairs.add(new double[]{1.68,0.0});
        testSetOfXYPairs.add(new double[]{1.7,0.0});
        testSetOfXYPairs.add(new double[]{1.73,0.0});
        testSetOfXYPairs.add(new double[]{1.75,0.0});
        testSetOfXYPairs.add(new double[]{1.78,0.0});
        testSetOfXYPairs.add(new double[]{1.8,0.0});
        testSetOfXYPairs.add(new double[]{1.83,0.0});
        var result2 = calculatorLogic.calculateLinearEquation(testSetOfXYPairs);
        assertEquals("Single Linear Regression Formula: y = 0.00x + 0.00", result2);

        //All X,Y values are 0,0
        testSetOfXYPairs.clear();
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        testSetOfXYPairs.add(new double[]{0.0,0.0});
        var result3 = calculatorLogic.calculateLinearEquation(testSetOfXYPairs);
        assertEquals("Error!!! Slope is being divided by zero. Enter new pair of XY pairs", result3);

        //Valid list of X,Y parameters
        testSetOfXYPairs.clear();
        testSetOfXYPairs.add(new double[]{1.47, 52.21});
        testSetOfXYPairs.add(new double[]{1.5,53.12});
        testSetOfXYPairs.add(new double[]{1.52,54.48});
        testSetOfXYPairs.add(new double[]{1.55,55.84});
        testSetOfXYPairs.add(new double[]{1.57,57.2});
        testSetOfXYPairs.add(new double[]{1.6,58.57});
        testSetOfXYPairs.add(new double[]{1.63,59.93});
        testSetOfXYPairs.add(new double[]{1.65,61.29});
        testSetOfXYPairs.add(new double[]{1.68,63.11});
        testSetOfXYPairs.add(new double[]{1.7,64.47});
        testSetOfXYPairs.add(new double[]{1.73,66.28});
        testSetOfXYPairs.add(new double[]{1.75,69.1});
        testSetOfXYPairs.add(new double[]{1.78,69.92});
        testSetOfXYPairs.add(new double[]{1.8,72.19});
        testSetOfXYPairs.add(new double[]{1.83,74.46});
        var result4 = calculatorLogic.calculateLinearEquation(testSetOfXYPairs);
        assertEquals("Single Linear Regression Formula: y = 61.82x + -39.89", result4);

    }//end of computeLinearEquation

    @Test
    void testPredictY_AddValuesAllOnOneLine_ReturnsAPredictionOfYOrReturnsErrorMessage(){
        //preq-UNIT-TEST-7

        ArrayList<Double> testY = new ArrayList<>();

        //Missing one or more parameters
        var errorResult = calculatorLogic.predictY(testY);
        assertEquals("List must contain ONLY 3 numbers", errorResult);

        //Valid list of parameters
        testY.clear();
        testY.add(1.535);
        testY.add(61.272186542107434);
        testY.add(-39.061955918838656);
        var Result = calculatorLogic.predictY(testY);
        assertEquals("Single Linear Regression Prediction: 54.990850423296244", Result);

    }//end of computePredictY

}//end class calculatorLogicTest