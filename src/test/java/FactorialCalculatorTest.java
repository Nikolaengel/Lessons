import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0), "Факториал 0 должен быть равен 1");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1), "Факториал 1 должен быть равен 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5), "Факториал 5 должен быть равен 120");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
        assertEquals("Факториал отрицательного числа не определен.", exception.getMessage());
    }
}