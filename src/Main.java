import java.util.Scanner;

public class Main {
    public static class Calculator {
        double result;

        String expression;
        Scanner input = new Scanner(System.in);

        public void input() {
            System.out.println("Enter the expression");
            expression = input.next();
        }

        public void calculate() {
            int countDigit = 0;
            for (char ch : expression.toCharArray()) {
                if (Character.isDigit(ch)) {
                    countDigit++;
                }
            }
            double[] arrayDigit = new double[10];
            char[] arrayOperation = new char[10];
            int n = 0, index = 0;
            String buff = "";
            for (int i = 0; i < expression.length(); i++) {
                if (Character.isDigit(expression.toCharArray()[i]) || expression.toCharArray()[i] == ',' || expression.toCharArray()[i] == '.')
                    buff += expression.toCharArray()[i];
                else {
                    arrayOperation[n] = expression.toCharArray()[i];
                    arrayDigit[n] = Double.parseDouble(buff.replace(",", "."));
                    buff = "";
                    n++;
                }
            }
            arrayDigit[n] = Double.parseDouble(buff.replace(",", "."));

            for (int i = 0; i < n; i++) {
                if (arrayOperation[index] == '*') {
                    arrayDigit[i] *= arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                index++;
            }
            index = 0;

            for (int i = 0; i < n; i++) {
                if (arrayOperation[index] == '/') {
                    arrayDigit[i] /= arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                index++;
            }
            index = 0;

            for (int i = 0; i < n; i++) {
                if (arrayOperation[index] == '+') {
                    arrayDigit[i] += arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                index++;
            }

            index = 0;
            for (int i = 0; i < n; i++) {
                if (arrayOperation[index] == '-') {
                    arrayDigit[i] -= arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }

                }
            }
            result = arrayDigit[0];
        }

        public void nextInput() {
            System.out.println("Enter the next expression");
            expression = Double.toString(result) + input.next();
            calculate();
        }

        public void print() {
            System.out.println("Result = " + result);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.input();
        calculator.calculate();
        calculator.print();
        Scanner input = new Scanner(System.in);
        String userAnswer;
        while (true) {
            System.out.println("Continue or exit? c/e");
            userAnswer = input.next();
            if (userAnswer.equals("e")) {
                System.out.println("Exit");
                break;
            } else if (userAnswer.equals("n")) {
                System.out.println("Invalid input");
                continue;
            }
            System.out.println("Continue the calculation or start a new one? c/n");
            userAnswer = input.next();
            if (userAnswer.equals("c")) {
                calculator.nextInput();
                calculator.print();
            } else if (userAnswer.equals("n")) {
                calculator.input();
                calculator.calculate();
                calculator.print();
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
