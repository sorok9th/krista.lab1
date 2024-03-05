import java.util.Scanner;

public class Calc {
    private double num1;
    private double num2;
    private String operation;
    public static void main(String[] args) {
        Calc calculator = new Calc();
        calculator.readNumbers();
    }

    public void readNumbers() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.print("Введите два числа и операцию (+, -, *, /) через пробел: ");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Некорректный ввод. Попробуйте снова.");
                }
                
                num1 = Double.parseDouble(parts[0]);
                operation = parts[1];
                num2 = Double.parseDouble(parts[2]);

                switch (operation) {
                    case "+":
                        calculateSum();
                        break;
                    case "-":
                        calculateDifference();
                        break;
                    case "*":
                        calculateProduct();
                        break;
                    case "/":
                        calculateQuotient();
                        break;
                    default:
                        System.out.println("Некорректная операция");
                }
                
                break; // выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите числа в правильном формате.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
    }

    public void calculateSum() {
        double sum = num1 + num2;
        System.out.println("Сумма чисел: " + sum);
    }

    public void calculateDifference() {
        double diff = num1 - num2;
        System.out.println("Разность чисел: " + diff);
    }

    public void calculateProduct() {
        double product = num1 * num2;
        System.out.println("Произведение чисел: " + product);
    }

    public void calculateQuotient() {
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Частное чисел: " + quotient);
        } else {
            System.out.println("Деление на ноль невозможно");
        }
    }

}