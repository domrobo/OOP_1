package lab1;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private char[][] matrixA;
    private char[][] matrixB;
    private char[][] matrixC;
    private int matrixARows;
    private int matrixACols;
    private int matrixBRows;
    private int matrixBCols;

    private int getInput(Scanner input, String prompt){
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

    public void createMatrices(Random r) {
        this.matrixA = new char[matrixARows][matrixACols];
        this.matrixB = new char[matrixBRows][matrixBCols];

        matrixRandomFill(this.matrixA, r);
        matrixRandomFill(this.matrixB, r);
    }

    private char[][] matrixRandomFill(char[][] matrix, Random r){
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = (char)(r.nextInt(26) + 'a');
            }
        }
        return matrix;
    }
    public void printMatrix(char[][] matrix){
        for (char[] row: matrix){
            for(char col: row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void calculateC() {
        this.matrixC = matrixAdd(this.matrixA, this.matrixB);
    }


    private char[][] matrixAdd(char[][] A, char[][] B) {
        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aRows != bRows || aColumns != bColumns) {
            throw new IllegalArgumentException("A:Rows: " + bRows + " did not match B:Columns " +  aColumns+ ".");
        }
        char[][] C = new char[aRows][bColumns];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = (char) ('a' + (A[i][j] - 'a' + B[i][j] - 'a') % 26);
            }
        }
        return C;
    }

    public void minMax() {
        char[][] matrix = this.matrixC;
        int totalSum = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            int targetValue = matrix[0][j] - 'a';

            for (int i = 1; i < matrix.length; i++) {
                int current = matrix[i][j] - 'a';
                if (j % 2 == 0) {
                    if (current > targetValue) targetValue = current;
                } else {
                    if (current < targetValue) targetValue = current;
                }
            }
            totalSum += targetValue;
        }
        System.out.println("Final Result Sum: " + totalSum);
    }

    public void printMatrixA(){
        printMatrix(this.matrixA);
    }

    public void setMatrixACols(Scanner input) {
        this.matrixACols = getInput(input, "Enter matrix A cols: ");
    }
    public int getMatrixACols() {
        return matrixACols;
    }

    public void setMatrixARows(Scanner input){
        this.matrixARows = getInput(input, "Enter matrix A rows: ");
    }
    public int getMatrixARows() {
        return matrixARows;
    }

    public void setMatrixBRows(Scanner input) {
        this.matrixBRows = getInput(input, "Enter matrix B rows: ");
    }
    public int getMatrixBRows() {
        return matrixBRows;
    }

    public void setMatrixBCols(Scanner input) {
        this.matrixBCols = getInput(input, "Enter matrix B cols: ");
    }
    public int getMatrixBCols() {
        return matrixBCols;
    }

    public char[][] getMatrixA() {
        return matrixA;
    }

    public char[][] getMatrixB() {
        return matrixB;
    }

    public char[][] getMatrixC() {
        return matrixC;
    }

    public void printMatrixB() {
        printMatrix(this.matrixB);
    }

    public void printMatrixC() {
        printMatrix(this.matrixC);
    }
}
