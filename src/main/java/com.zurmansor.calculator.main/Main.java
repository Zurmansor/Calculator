import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static String convert(String string) {

        String result = "";
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                result += string.charAt(i);
            } else {
                stack.push(string.charAt(i));
            }
        }
        while (!stack.isEmpty()) {

            result += stack.pop();
        }



        return result;
    }

    public static void main (String[] args) {

        System.out.println(convert("3+5-8"));
    }


}