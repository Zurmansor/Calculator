import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    private static String convert(String string) {

        String result = "";
        Deque<Character> stack = new ArrayDeque<Character>();
        ArrayList<Character> numbers = new ArrayList<Character>();
// TODO: большие числа
        for (int i = 0; i < string.length(); i++) {
            // цифры в строку
            if (Character.isDigit(string.charAt(i))) {
                result += string.charAt(i);

            } else if (string.charAt(i)=='(') {
                    stack.push(string.charAt(i));
            }else if (string.charAt(i) == ')') {

// TODO:если мы не находим (
// TODO: оптимизировать вайл
                while (!stack.peek().equals('(')) {
                    result += stack.pop();
                    }
                stack.pop();
            }
            //операции в стек
            else {
                stack.push(string.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main (String[] args) {

        System.out.println(convert("(1+2)*4"));
    }

}
