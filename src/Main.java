import java.util.Scanner;


public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double result = userInput(in);
        String userAnswer;

        while(true) {
            System.out.println("Continue or exit? c/e");
            userAnswer = in.next();
            if (userAnswer.equals("e")){
                System.out.println("Exit");
                break;
            }
            else if (userAnswer.equals("n")){
                System.out.println("Invalid input");
                continue;
            }
            System.out.println("Continue the calculation or start a new one? c/n");
            userAnswer = in.next();
            if(userAnswer.equals("c")){
                System.out.println("Enter a number");
                double num = in.nextDouble();
                System.out.println("Enter the operation");
                String operation = in.next();
                result = nextCalculate(num, result, operation);
                System.out.println("Result = " + result);
            }
            else if (userAnswer.equals("n")){
                result = userInput(in);
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
    public static double userInput(Scanner in) {
        System.out.println("Enter the first number");
        double num1 = in.nextDouble();
        System.out.println("Enter the second number");
        double num2 = in.nextDouble();
        System.out.println("Enter the operation");
        String operation = in.next();
        double result = calculate(num1, num2, operation);
        System.out.println("Result = " + result);
        return result;
    }
    public static double calculate(double num1, double num2, String operation) {
        double result;
        switch (operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
            case "%": result = num1 % num2; break;
            default: result = 0.0; break;
        }
        return result;
    }
    public static double nextCalculate(double num, double result, String operation) {
        switch (operation) {
            case "+": result += num; break;
            case "-": result -= num; break;
            case "*": result *= num; break;
            case "/": result /= num; break;
            case "%": result %= num; break;
            default: break;
        }
        return result;
    }
}
