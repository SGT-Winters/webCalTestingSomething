package com.example.calculator;

import java.util.ArrayList;

public class calculatorLogic {

    public String computeSampleDeviation(ArrayList<Double> numList) {
        //preq-LOGIC-3

        if (numList.size() < 2) {
            return "List must contain at least 2 numbers";
        }

        double sum = 0.0;
        for (double num : numList) {
            sum += num;
        }
        double mean = sum / numList.size();

        double squaredDifferenceSum = 0.0;
        for (double num : numList) {
            squaredDifferenceSum += Math.pow(num - mean, 2);
        }

        double variance = squaredDifferenceSum / (numList.size() - 1);

        String devNum = "" + Math.sqrt(variance);

        return "Sample Standard Deviation: " + devNum;
    }

    public String computePopulationDeviation(ArrayList<Double> numList) {
        //preq-LOGIC-4

        if (numList.size() < 2) {
            return "List must contain at least 2 numbers";
        }

        double sum = 0.0;
        for (double num : numList) {
            sum += num;
        }
        double mean = sum / numList.size();

        double squaredDifferenceSum = 0.0;
        for (double num : numList) {
            squaredDifferenceSum += Math.pow(num - mean, 2);
        }

        double variance = squaredDifferenceSum / numList.size();

        String devNum = "" + Math.sqrt(variance);

        return "Population Standard Deviation: " + devNum;
    }

    public String getMean (ArrayList<Double> numList) {
        //preq-LOGIC-5

        if (numList.size() < 2) {
            return "List must contain at least 2 numbers";
        }

        double sum = 0.0;
        for (double num : numList) {
            sum += num;
        }

        double mean = sum / numList.size();

        String meanNum = "" + mean;

        return "Mean: " + meanNum;

    }

    public String getZScore (ArrayList<Double> numList) {
        //preq-LOGIC-3

        if(numList.size() != 3){
            return "List must contain ONLY 3 numbers";
        }else if(numList.get(2) == 0){
            return "Standard Deviation Cannot Be Zero";
        }

        double score = (numList.get(0) - numList.get(1)) / numList.get(2);

        String zScore = "" + score;

        return "ZScore: " + zScore;
    }

    public String calculateLinearEquation(ArrayList<double[]> points) {
        //preq-LOGIC-7

        if (points.size() < 2) {
            return "List must contain at least 2 XY Points";
        }

        int n = points.size();
        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumX2 = 0.0;

        for (double[] point : points) {
            double x = point[0];
            double y = point[1];
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }

        double numerator = n * sumXY - sumX * sumY;
        double denominator = n * sumX2 - sumX * sumX;
        if (denominator == 0) {
            return "Error!!! Slope is being divided by zero. Enter new pair of XY pairs";
        }
        double m = numerator / denominator;

        double meanX = sumX / n;
        double meanY = sumY / n;
        double b = meanY - m * meanX;

        String formattedEquation = String.format("y = %.2fx + %.2f", m, b);

        return "Single Linear Regression Formula: " + formattedEquation;
    }

    public String predictY(ArrayList<Double> numList) {
        //preq-LOGIC-8

        if(numList.size() != 3){
            return "List must contain ONLY 3 numbers";
        }

        double calY = (numList.get(0) * numList.get(1)) + numList.get(2);
        String resultY = "" + calY;

        return "Single Linear Regression Prediction: " + resultY;
    }

}