import java.util.Scanner;

public class UserInput {
    static Scanner input = new Scanner(System.in);
    static String expression;
    public static String inputExpression(){
        System.out.println("Enter the expression");
        expression = input.next();
        return expression;
    }

    public String inputAnswer(){
        return input.next();
    }

    public static String nextInputExpression(){
        System.out.println("Enter the next expression");
        expression = expression + input.next();
        return expression;
    }

}
