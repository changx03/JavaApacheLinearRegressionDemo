/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinearregression;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 *
 * @author Luke Chang
 */
public class LinearRegression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinearRegression lr = new LinearRegression();
        //lr.linearRegressionDemo2D();
        
        lr.multiLinearRegressionDemo();
    }

    // Estimate a model from a double[][] array of data points
    public void linearRegressionDemo2D() {
        double[][] data = {{1, 3}, {2, 5}, {3, 7}, {4, 14}, {5, 11}};
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);

        System.out.println(regression.getIntercept());
        // displays intercept of regression line

        System.out.println(regression.getSlope());
        // displays slope of regression line

        System.out.println(regression.getSlopeStdErr());
        // displays slope standard error
    }

    // multiple linear regression use OLS method (Ordinary least squares regression)
    public void multiLinearRegressionDemo() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[]{1, 7, 9, 15, 22};
        double[][] x = new double[5][];
        x[0] = new double[]{0, 0, 0};
        x[1] = new double[]{1, 1, 1};
        x[2] = new double[]{0, 1, 2};
        x[3] = new double[]{1, 2, 3};
        x[4] = new double[]{3, 3, 4};
        regression.newSampleData(y, x);

        double[] beta = regression.estimateRegressionParameters();
        
        for (double bVal : beta) {
            System.out.println(bVal);
        }

        double[] residuals = regression.estimateResiduals();
        System.out.println("Residuals:");
        for (double rVal : residuals) {
            System.out.println(rVal);
        }
        
        double[][] parametersVariance = regression.estimateRegressionParametersVariance();

        double regressandVariance = regression.estimateRegressandVariance();
        System.out.println("regressandVariance = " + regressandVariance);
        
        double rSquared = regression.calculateRSquared();
        System.out.println("rSquared = " + rSquared);
        
        double sigma = regression.estimateRegressionStandardError();
        System.out.println("sigma = " + sigma);
    }
}
