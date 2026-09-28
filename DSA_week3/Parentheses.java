import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "[()]{}{[()()]()}";
        String test2 = "[(])";
        
        System.out.println(test1 + " : " + isBalanced(test1));
        System.out.println(test2 + " : " + isBalanced(test2)); 
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi ngoặc: ");
        if (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(isBalanced(input));
        }
        scanner.close();
    }
}
