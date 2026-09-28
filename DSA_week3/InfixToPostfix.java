import java.util.Stack;

public class InfixToPostfix {
    
    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    public static String convert(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        String[] tokens = infix.split("\\s+");
        
        for (String s : tokens) {
            if (s.equals("(")) {
                stack.push(s);
            } 
            
            else if (s.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); 
            } 
            
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(s)) {
                    postfix.append(stack.pop()).append(" ");
                }
               
                stack.push(s);
            } 
            
            else {
                postfix.append(s).append(" ");
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        
        return postfix.toString().trim();
    }

    public static void main(String[] args) {
       
        String infix1 = "( 1 + 2 ) * 3";
        System.out.println("Trung tố: " + infix1);
        System.out.println("Hậu tố:   " + convert(infix1)); 
        
        
        String infix2 = "A * B + C * D";
        System.out.println("Trung tố: " + infix2);
        System.out.println("Hậu tố:   " + convert(infix2)); 
    }
}
