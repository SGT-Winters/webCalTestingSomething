package com.example.WebCalApp;

import com.example.calculator.calculatorLogic;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class HelloController {

    private final calculatorLogic calculatorLogic = new calculatorLogic();

    @PostMapping("/computeSampleDeviation")
    public String computeSampleDeviation(@RequestParam("values") String values) {
        ArrayList<Double> numList = new ArrayList<>();
        try {
            Arrays.stream(values.split("\\n"))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .forEach(line -> numList.add(Double.parseDouble(line)));
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }
        return calculatorLogic.computeSampleDeviation(numList);
    }

    @PostMapping("/computePopulationDeviation")
    public String computePopulationDeviation(@RequestParam("values") String values) {
        ArrayList<Double> numList = new ArrayList<>();
        try {
            Arrays.stream(values.split("\\n"))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .forEach(line -> numList.add(Double.parseDouble(line)));
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }

        return calculatorLogic.computePopulationDeviation(numList);
    }

    @PostMapping("/computeMean")
    public String computeMean(@RequestParam("values") String values) {
        ArrayList<Double> numList = new ArrayList<>();
        try {
            Arrays.stream(values.split("\\n"))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .forEach(line -> numList.add(Double.parseDouble(line)));
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }

        return calculatorLogic.getMean(numList);
    }

    @PostMapping("/computeZScore")
    public String computeZScore(@RequestParam("values") String values) {
        ArrayList<Double> numList = new ArrayList<>();
        try {
            // Parse input into a list of doubles
            Arrays.stream(values.split(","))
                    .map(String::trim)
                    .filter(value -> !value.isEmpty())
                    .forEach(value -> numList.add(Double.parseDouble(value)));
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }

        return calculatorLogic.getZScore(numList);
    }

    @PostMapping("/computePredictY")
    public String computePredictY(@RequestParam("values") String values) {
        ArrayList<Double> numList = new ArrayList<>();
        try {
            // Parse input into a list of doubles
            Arrays.stream(values.split(","))
                    .map(String::trim)
                    .filter(value -> !value.isEmpty())
                    .forEach(value -> numList.add(Double.parseDouble(value)));
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }

        return calculatorLogic.predictY(numList);
    }

    @PostMapping("/calculateLinearEquation")
    public String calculateLinearEquation(@RequestParam("pairs") String pairs) {
        ArrayList<double[]> points = new ArrayList<>();
        try {
            // Parse input into a list of X,Y pairs
            Arrays.stream(pairs.split("\\|"))
                    .map(String::trim)
                    .filter(pair -> !pair.isEmpty())
                    .forEach(pair -> {
                        String[] xy = pair.split(",");
                        if (xy.length != 2) {
                            throw new IllegalArgumentException("Invalid X,Y pair: " + pair);
                        }
                        points.add(new double[] {
                                Double.parseDouble(xy[0].trim()),
                                Double.parseDouble(xy[1].trim())
                        });
                    });
        } catch (Exception e) {
            return "test";
        }

        // Ensure at least two points are provided
        if (points.size() < 2) {
            return "Error: At least two X,Y pairs are required.";
        }

        // Perform computation
        return calculatorLogic.calculateLinearEquation(points);
    }


}