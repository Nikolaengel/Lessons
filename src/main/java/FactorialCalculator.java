public class FactorialCalculator {

    /**
     * Вычисляет факториал числа.
     *
     * @param n Неотрицательное целое число.
     * @return Факториал числа n.
     * @throws IllegalArgumentException Если n отрицательное.
     */
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}