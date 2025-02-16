import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1, "Факториал 0 должен быть равен 1");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1, "Факториал 1 должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120, "Факториал 5 должен быть равен 120");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-1);
    }
}