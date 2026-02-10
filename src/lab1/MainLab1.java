package lab1;

import java.util.Random;
import java.util.Scanner;

import static lab1.Matrix.*;

public class MainLab1 {



    public static void main(String[] args) {
        Random r = new Random();
        Matrix newMatrix = new Matrix();

        try (Scanner input = new Scanner(System.in)) {

            newMatrix.setMatrixARows(input);
            newMatrix.setMatrixACols(input);
            newMatrix.setMatrixBRows(input);
            newMatrix.setMatrixBCols(input);
        }

        newMatrix.createMatrices(r);

        System.out.println("Matrix A: ");
        newMatrix.printMatrixA();

        System.out.println("Matrix B: ");
        newMatrix.printMatrixB();

        System.out.println("Matrix C: ");
        newMatrix.calculateC();
        newMatrix.printMatrixC();
        newMatrix.minMax();


    }

}
