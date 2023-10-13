import java.util.Scanner;


public class Main
{
    public static class Calculator {
        double num1, num2, result;
        String operation;
        Scanner input = new Scanner(System.in);
        public void input(){
            System.out.println("Enter the first number");
            this.num1 = input.nextDouble();
            System.out.println("Enter the second number");
            this.num2 = input.nextDouble();
            System.out.println("Enter the operation");
            this.operation = input.next();
        }
        public void nextInput(){
            System.out.println("Enter a number");
            this.num1 = input.nextDouble();
            System.out.println("Enter the operation");
            this.operation = input.next();
        }
        public void print(){
            System.out.println("Result = " + result);
        }
        public void calculate(){
            switch (operation) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
                case "%": result = num1 % num2; break;
                default: result = 0.0; break;
            }
        }
        public void nextCalculate(){
            switch (operation) {
                case "+": result += num1; break;
                case "-": result -= num1; break;
                case "*": result *= num1; break;
                case "/": result /= num1; break;
                case "%": result %= num1; break;
                default: break;
            }
        }
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.input();
        calculator.calculate();
        calculator.print();
        Scanner input = new Scanner(System.in);
        String userAnswer;
        while(true) {
            System.out.println("Continue or exit? c/e");
            userAnswer = input.next();
            if (userAnswer.equals("e")){
                System.out.println("Exit");
                break;
            }
            else if (userAnswer.equals("n")){
                System.out.println("Invalid input");
                continue;
            }
            System.out.println("Continue the calculation or start a new one? c/n");
            userAnswer = input.next();
            if(userAnswer.equals("c")){
                calculator.nextInput();
                calculator.nextCalculate();
                calculator.print();
            }
            else if (userAnswer.equals("n")){
                calculator.input();
                calculator.calculate();
                calculator.print();
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
}
