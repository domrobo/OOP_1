package lab1;

import java.util.Random;
import java.util.Scanner;

public class MainLab1 {
    private char[][] matrixA;
    private char[][] matrixB;
    private char[][] matrixC;
    private int matrixARows;
    private int matrixACols;
    private int matrixBRows;
    private int matrixBCols;


    public static void main(String[] args) {
        MainLab1 sample = new MainLab1();
        Random r = new Random();

        try (Scanner input = new Scanner(System.in)) {

            sample.matrixARows = getInput(input, "Enter matrix A rows: ");
            sample.matrixACols = getInput(input, "Enter matrix A cols: ");

            sample.matrixBRows = getInput(input, "Enter matrix B rows: ");
            sample.matrixBCols = getInput(input, "Enter matrix B cols: ");
        }
        System.out.println("Matrix A");
        sample.matrixA = new char[sample.matrixARows][sample.matrixACols];
        sample.matrixA = matrixRandomFill(sample.matrixA, r);
        printMatrix(sample.matrixA);

        System.out.println("Matrix B");
        sample.matrixB = new char[sample.matrixBRows][sample.matrixBCols];
        sample.matrixB = matrixRandomFill(sample.matrixB, r);
        printMatrix(sample.matrixB);

        System.out.println("Matrix C");
        sample.matrixC = matrixAdd(sample.matrixA, sample.matrixB);
        printMatrix(sample.matrixC);

        minMax(sample.matrixC);

    }
    public static int getInput(Scanner input, String prompt){
        while (true){
            System.out.print(prompt);
            if(input.hasNextInt()){
                int value = input.nextInt();
                if (value > 0) return value;
                System.out.println("Enter positive num");
            }else {
                System.out.println("Enter only int nums.");
                input.nextLine();
            }
        }
    }
    public static char[][] matrixRandomFill(char[][] matrix, Random r){
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = (char)(r.nextInt(26) + 'a');
            }
        }
        return matrix;
    }
    public static void printMatrix(char[][] matrix){
        for (char[] row: matrix){
            for(char col: row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static char[][] matrixAdd(char[][] A, char[][] B) {
        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aRows != bRows || aColumns != bColumns) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }
        char[][] C = new char[aRows][bColumns];

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                C[i][j] = (char) ('a' + (A[i][j] - 'a' + B[i][j] - 'a') % 26);
            }
        }
        return C;
    }
    public static void minMax(char[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalSum = 0;

        int minSum = 0;
        int maxSum = 0;
        for (int j = 0; j < cols; j++){
            int maxValue = matrix[0][j] - 'a';
            int minValue = matrix[0][j] - 'a';
            if (j % 2 == 0) {
                for (char[] chars : matrix) {
                    int current = chars[j] - 'a';
                    if (current < minValue) {
                        minValue = current;
                    }
                }
            } else {
                for (char[] chars : matrix) {
                    int current = chars[j] - 'a';
                    if (current > maxValue) {
                        maxValue = current;

                    }
                }
            }
            minSum += minValue;
            maxSum += maxValue;
            totalSum += minValue + maxValue;
        }
        System.out.println("Sum of max values: " +maxSum);
        System.out.println("Sum of min values: " + minSum);
        System.out.println("Total sum: " + totalSum);
    }
}
