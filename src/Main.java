//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        pointThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        boolean a = inSumRange(1, 19);
        System.out.println(a);
        isNumPos(-5);
        boolean b = isNumPosBl(2);
        System.out.println(b);
        checkStrCount("Куда я жмал ", 5);
        boolean d = isLeapYear(100);
        System.out.println(d);

        int[] numbers = {1, 0, 0 ,1, 1, 0 ,0, 1};
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 1){
                numbers[i] = 0;
            } else if (numbers[i] == 0){
                numbers[i] = 1;
            }
        }

        int[] emptyArray = new int[100];
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = i + 1;
        }

        int[] countNum = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < countNum.length; i++) {
            if (countNum[i] < 6) {
                countNum[i] *= 2;
            }
        }

        int k = 5;
        int[][] matrix = new int[k][k];

        // Заполняем главную и обратную диагонали
        for (int i = 0; i < k; i++) {
            matrix[i][i] = 1; // Главная диагональ
            matrix[i][k - 1 - i] = 1; // Обратная диагональ
        }

        // Вывод массива
        System.out.println("Массив с двумя диагоналями:");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[] resultArray = createArray(5, 7);


    }

    public static void pointThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 42;
        int b = 52;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 99;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else System.out.println("Зеленый");
    }

     public static void compareNumbers() {
        int a = 10;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        } else System.out.println("a < b");
     }

     public static boolean inSumRange(int x, int y) {
        boolean c = x + y > 10 && x + y <= 20;
         return c;
     }

     public static void isNumPos(int x) {
        if (x < 0) {
            System.out.println("Число отрицательно");
        } else System.out.println("Число положительно");
     }

     public static boolean isNumPosBl(int x) {
        return x < 0;
     }

     public static void checkStrCount(String s, int x) {
        for (int i = 0; i < x; i++) {
            System.out.println(s);
        }
     }

    public static boolean isLeapYear(int year) {
        // Условие високосного года
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len]; // Создаем массив заданной длины

        // Заполняем массив значением initialValue
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        return array; // Возвращаем массив
    }

}