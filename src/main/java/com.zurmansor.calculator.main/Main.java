import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    private static String sortingStation(String string) {

        String result = "";
        char currentCharacter;
        Deque<Character> stack = new ArrayDeque<Character>();
        ArrayList<Character> numbers = new ArrayList<Character>();
        // TODO: большие числа

        for (int i = 0; i < string.length(); i++) {
            currentCharacter = string.charAt(i);
            // цифры в строку
            if (Character.isDigit(currentCharacter)) {
                result += currentCharacter;
            } else if (currentCharacter=='(') {
                stack.push(currentCharacter);
            }else if (currentCharacter == ')') {
                // TODO:если мы не находим '('
                // TODO: оптимизировать вайл
                while (!stack.peek().equals('(')) {
                    result += stack.pop();
                }
                stack.pop();
            }
            //операции в стек
            else {
                // если приоритет операции выше последней операции в стеке, то она идет напрямую в result
                // в другом случае она идет в стек, а последняя стековая идет в result
// TODO: только если используются операции + или -

//                System.out.println();
                if (!stack.isEmpty() && !stack.peek().equals('(')) {
                    result += stack.pop();
                }
                stack.push(currentCharacter);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main (String[] args) {
        String expr1 = "1+2-(4+6-7)";
        String expr2 = "1+2-4+6-7+1";

        System.out.println(sortingStation(expr1));
    }

}
