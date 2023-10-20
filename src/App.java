public class App {
    public void Run(){
        String userAnswer, userExpression, result;

        Calculator calculator = new Calculator();
        UserInput userInput = new UserInput();
        ConsoleOutput output = new ConsoleOutput();

        try {
            userExpression = userInput.inputExpression();
            result = calculator.calculate(userExpression);
            output.printResult(result);

            while (true) {
                output.printQuestion1();

                userAnswer = userInput.inputAnswer();

                if (userAnswer.equals("e")) {
                    output.printExit();
                    break;
                } else if (!userAnswer.equals("c")) {
                    output.printError();
                    continue;
                }

                output.printQuestion2();

                userAnswer = userInput.inputAnswer();

                if (userAnswer.equals("c")) {
                    result = UserInput.nextInputExpression();
                    result = calculator.calculate(result);

                    output.printResult(result);
                } else if (userAnswer.equals("n")) {
                    result = UserInput.inputExpression();
                    result = calculator.calculate(result);

                    output.printResult(result);
                } else {
                    output.printError();
                }
            }
        } catch(Exception exception){
            output.printException(exception);
        }

    }
}
