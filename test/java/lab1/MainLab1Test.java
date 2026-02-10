import lab1.MainLab1;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;



import static org.junit.jupiter.api.Assertions.*;

class MainLab1Test {


    @Test
    void matrixAdd_basicAddition() {
        char[][] A = {
                {'a', 'b'},
                {'c', 'd'}
        };
        char[][] B = {
                {'a', 'a'},
                {'a', 'a'}
        };

        char[][] result = MainLab1.matrixAdd(A, B);

        assertEquals('a', result[0][0]);
        assertEquals('b', result[0][1]);
        assertEquals('c', result[1][0]);
        assertEquals('d', result[1][1]);
    }

    @Test
    void matrixAdd_allZPlusZ() {
        char[][] A = {
                {'z', 'z'},
                {'z', 'z'}
        };
        char[][] B = {
                {'z', 'z'},
                {'z', 'z'}
        };

        char[][] result = MainLab1.matrixAdd(A, B);

        for (char[] row : result) {
            for (char c : row) {
                assertEquals('y', c); // (25+25)%26 = 24 → 'y'
            }
        }
    }

    @Test
    void matrixAdd_shouldThrowException_whenRowsMismatch() {
        char[][] A = {{'a', 'b'}};
        char[][] B = {
                {'a', 'b'},
                {'c', 'd'}
        };

        assertThrows(
                IllegalArgumentException.class,
                () -> MainLab1.matrixAdd(A, B)
        );
    }

    @Test
    void matrixAdd_shouldThrowException_whenColumnsMismatch() {
        char[][] A = {
                {'a', 'b'},
                {'c', 'd'}
        };
        char[][] B = {
                {'a'}
        };

        assertThrows(
                IllegalArgumentException.class,
                () -> MainLab1.matrixAdd(A, B)
        );
    }


    @Test
    void matrixRandomFill_shouldFillOnlyLowercaseLetters() {
        char[][] matrix = new char[5][5];
        Random r = new Random(42); // deterministic

        MainLab1.matrixRandomFill(matrix, r);

        for (char[] row : matrix) {
            for (char c : row) {
                assertTrue(c >= 'a' && c <= 'z');
            }
        }
    }

    @Test
    void matrixRandomFill_shouldNotChangeMatrixSize() {
        char[][] matrix = new char[3][7];
        Random r = new Random();

        char[][] result = MainLab1.matrixRandomFill(matrix, r);

        assertEquals(3, result.length);
        assertEquals(7, result[0].length);
    }


    @Test
    void minMax_shouldNotThrowException() {
        char[][] matrix = {
                {'a', 'c', 'b'},
                {'d', 'b', 'z'},
                {'c', 'a', 'y'}
        };

        assertDoesNotThrow(() -> MainLab1.minMax(matrix));
    }

    @Test
    void minMax_correctOutputForKnownMatrix() {
        char[][] matrix = {
                {'a', 'c'},
                {'d', 'b'}
        };

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MainLab1.minMax(matrix);

        String output = out.toString();

        assertTrue(output.contains("Sum of max values"));
        assertTrue(output.contains("Sum of min values"));
        assertTrue(output.contains("Total sum"));
    }


    @Test
    void getInput_shouldReturnPositiveInt() {
        Scanner scanner = new Scanner("5");

        int result = MainLab1.getInput(scanner, "");

        assertEquals(5, result);
    }

    @Test
    void getInput_shouldSkipInvalidInput() {
        Scanner scanner = new Scanner("abc\n-3\n7");

        int result = MainLab1.getInput(scanner, "");

        assertEquals(7, result);
    }


    @Test
    void printMatrix_shouldNotThrowException() {
        char[][] matrix = {
                {'a', 'b'},
                {'c', 'd'}
        };

        assertDoesNotThrow(() -> MainLab1.printMatrix(matrix));
    }
}