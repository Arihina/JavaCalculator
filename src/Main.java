import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number");
        double num1 = in.nextDouble();
        System.out.println("Enter the second number");
        double num2 = in.nextDouble();
        System.out.println("Enter the operation");
        String operation = in.next();
        double result = calculate(num1, num2, operation);
        System.out.println("Result = " + result);
    }
    public static double calculate(double num1, double num2, String operation){
        double result;
        switch (operation){
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
            case "%": result = num1 % num2; break;
            default: result = 0.0; break;
        }
        return result;
    }
}