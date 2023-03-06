import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    public static void main(String[] args) {
        //
    }

    public static String evaluate(String expr) {
        expr = expr.replace(" ", "");
        // (5+mad(5,3,6))+(4*2)+sinh(2)
        String[] multiValueFunctions = { "mad", "sd", "ab^x", "arccos", "sinh", "gamma", };
        for (String func : multiValueFunctions) {
            if (expr.contains(func)) {
                int funcStart = expr.indexOf(func);
                int funcEnd = expr.indexOf(")", funcStart);
                int i1 = funcStart + func.length() + 1;
                int i2 = expr.indexOf(")", i1);
                String[] inputs = expr.substring(i1, i2).split(",");
                for (int i = 0; i < inputs.length; ++i) {
                    if (isComplexExpr(inputs[i])) {
                        inputs[i] = evaluate(expr);
                    }
                }

            }
        }

        // (5+a)+(4.32432*2.4563)
        // convert to postfix
        // evaluate postfix
        return "";
    }

    private static String toPostfix(String expr) {
        ArrayList<String> tokens = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("#");
        String postfix = "";
        // expr.split()
        for (String token : tokens) {
            //
        }
        return "";
    }

    private static int precedence(String symbol) {
        switch (symbol) {
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            case "^":
                return 4;
            case "(":
            case ")":
                return 1;
            default:
                return 0;
        }
    }

    private static boolean isOperator(String symbol) {
        switch (symbol) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
            case "(":
            case ")":
                return true;
            default:
                return false;
        }
    }

    private static boolean isComplexExpr(String expr) {
        try {
            Float.parseFloat(expr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
