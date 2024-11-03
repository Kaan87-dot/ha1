package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should toggle negative sign correctly")
    void testToggleNegativeSign() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressNegativeKey();
        calc.pressNegativeKey();
        String expected = "5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display error when performing unary operation with invalid input")
    void testInvalidUnaryOperationInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0); // 0 für 1/x
        calc.pressUnaryOperationKey("1/x");

        String expected = "Error"; // Erwartetes Verhalten: 1/0 führt zu einem Fehler
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }




    @Test
    @DisplayName("should not accept more than 10 digits")
    void testTooManyDigits() {
        Calculator calc = new Calculator();

        // Eingabe von 11 Ziffern, was über die 10-stellige Grenze hinausgeht
        for (int i = 0; i < 11; i++) {
            calc.pressDigitKey(1);
        }

        String expected = "1111111111"; // Der Bildschirm sollte nur die ersten 10 Ziffern anzeigen
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


 //TODO hier weitere Tests erstellen
}

