package Balance;

import java.util.Stack;
import java.io.*;
import java.nio.charset.*;
import org.apache.commons.io.*;

public class Balance {
    public static void main(String[] args) {
        String data;
        try {
            data = convertFileToString();
        } catch (Exception e) {
            data = "";
            System.out.println("Exception: " + e);
        } finally {
            System.out.println(balance(data));
        }
    }

    public static boolean balance(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static String convertFileToString() throws IOException {
        File file = new File("data.txt");
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}