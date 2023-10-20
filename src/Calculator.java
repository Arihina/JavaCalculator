public class Calculator {
    String mainExpression;

    public String calculate(String expression) {
        mainExpression = expression;
        parseBracket();
        mainExpression = calculateExpression(mainExpression);
        return mainExpression;
    }

    public void parseBracket() {
        String partResult = "", buffExpression ="";
        boolean flag = false;
        boolean flagCalc = false;

        for (int i = 0; i < mainExpression.length(); i++) {
            if (mainExpression.toCharArray()[i] == '(' && !flag) {
                flag = true;
                for (int j = i + 1; j < mainExpression.length(); j++){
                    if (mainExpression.toCharArray()[j] == ')'){
                        flag = false;
                        break;
                    }

                    buffExpression += mainExpression.toCharArray()[j];

                    if (mainExpression.toCharArray()[j] == '('){
                        buffExpression = "";
                    }
                }
                flagCalc = true;
            }
            if (flag) {
                System.out.println("closing bracket not found");
                return;
            }
            else if (flagCalc) {
                partResult = calculateExpression(buffExpression);
                mainExpression = mainExpression.replace("(" + buffExpression + ")", partResult);
                buffExpression = "";
                flagCalc = false;
                i = 0;
            }
        }
    }

    public String calculateExpression(String expression)  {
        double[] arrayDigit = new double[10];
        char[] arrayOperation = new char[10];

        int n = 0, index = 0;
        String buff = "";

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.toCharArray()[i]) || expression.toCharArray()[i] == ','
                    || expression.toCharArray()[i] == '.')
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
            if (arrayOperation[index] == '*' || arrayOperation[index] == '/') {
                if (arrayOperation[index] == '*') {
                    arrayDigit[i] *= arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                if (arrayOperation[index] == '/') {
                    arrayDigit[i] /= arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                i--;
            }
            else
                index++;
        }
        index = 0;

        for (int i = 0; i < n; i++) {
            if (arrayOperation[index] == '+' || arrayOperation[index] == '-') {
                if (arrayOperation[index] == '+'){
                    arrayDigit[i] += arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                if (arrayOperation[index] == '-') {
                    arrayDigit[i] -= arrayDigit[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        arrayDigit[j] = arrayDigit[j + 1];
                        arrayOperation[j - 1] = arrayOperation[j];
                    }
                }
                i--;
            }
            else
                index++;
        }

        return Double.toString(arrayDigit[0]);
    }

}
