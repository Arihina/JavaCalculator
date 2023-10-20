public class ConsoleOutput {
    public void printResult(String result){
        System.out.println("Result = " + result);
    }

    public void printQuestion1(){
        System.out.println("Continue or exit? c/e");
    }

    public void printQuestion2(){
        System.out.println("Continue the calculation or start a new one? c/n");
    }

    public void printError(){
        System.out.println("Invalid input");
    }

    public void printExit(){
        System.out.println("Exit");
    }

    public void printException(Exception exception){
        System.out.println("Error");
        System.out.println("\t" + exception);
    }
}
