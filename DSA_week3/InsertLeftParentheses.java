import java.util.Scanner;
import java.util.Stack;

public class InsertLeftParentheses {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();  
        Stack<String> vals = new Stack<>(); 
        
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        
        String[] tokens = input.split("\\s+");
        
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } 
            
            else if (s.equals(")")) {
                String op = ops.pop();      
                String val2 = vals.pop();   
                String val1 = vals.pop();  
                
                String subExpr = "( " + val1 + " " + op + " " + val2 + " )";
                
                vals.push(subExpr);
            } 
           
            else {
                vals.push(s);
            }
        }
        
        System.out.println(vals.pop());
    }
}
