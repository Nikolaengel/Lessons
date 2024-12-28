//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Petrov Petr", "Manager", "petrov@mail.com", "892345678", 40000, 45);
        employees[2] = new Employee("Sidorov Sidr", "Developer", "sidorov@mail.com", "893456789", 50000, 28);
        employees[3] = new Employee("Smirnov Alexey", "Analyst", "smirnov@mail.com", "894567890", 35000, 33);
        employees[4] = new Employee("Kuznetsova Maria", "Designer", "kuznetsova@mail.com", "895678901", 45000, 40);

    }
}