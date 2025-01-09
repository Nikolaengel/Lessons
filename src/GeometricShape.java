public interface GeometricShape {
    // Методы для расчета площади и периметра
    double calculatePerimeter();
    double calculateArea();

    // Методы для установки и получения цветов
    void setFillColor(String color);
    void setBorderColor(String color);
    String getFillColor();
    String getBorderColor();

    // Дефолтный метод для вывода характеристик фигуры
    default void printCharacteristics() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
