//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Неверное количество строк: ожидается 4, но получено " + array.length);
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в одной из строк: ожидается 4.");
            }
        }

        int sum = 0; // Переменная для суммы элементов

        // Проход по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]); // Преобразование строки в int
                } catch (NumberFormatException e) {
                    // Если не удалось преобразовать в число, бросается исключение
                    throw new MyArrayDataException(
                            String.format("Ошибка в ячейке [%d][%d]: '%s' не является числом", i, j, array[i][j])
                    );
                }
            }
        }

        return sum; // Возвращаем сумму
    }

    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива с неверным размером
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // Пример массива с некорректными данными
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма элементов массива: " + processArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + processArray(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + processArray(wrongDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}