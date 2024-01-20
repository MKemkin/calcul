import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Консольный калькулятор");
            System.out.println("Введите выражение в формате 'a оператор b' (например, 2 + 3):");

            // Чтение входных данных в одной строке
            String input = scanner.nextLine();

            // Разделение строки на числа и оператор
            String[] tokens=input.split(" ");
            if (tokens.length!=3) {
                throw new IllegalArgumentException("Неверный формат ввода");
            }

            // Парсинг чисел
            int num1 = Integer.parseInt(tokens[0]);
            char operator = tokens[1].charAt(0);
            int num2 = Integer.parseInt(tokens[2]);

            // Проверка диапазона чисел
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
            }

            // Выполнение операции
            int result = 0;
            switch (operator) {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Ошибка: деление на ноль");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция");
            }

            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введены некорректные числа");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}