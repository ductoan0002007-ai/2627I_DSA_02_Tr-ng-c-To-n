import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {

    public static double evaluate(String postfix) {
        Stack<Double> stack = new Stack<>();
        
        String[] tokens = postfix.split("\\s+");
        
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            else if (s.equals("-")) {
                double val2 = stack.pop(); 
                double val1 = stack.pop(); 
                stack.push(val1 - val2);
            } 
            else if (s.equals("/")) {
                double val2 = stack.pop();
                double val1 = stack.pop();
                stack.push(val1 / val2);
            } 
        
            else {
                stack.push(Double.parseDouble(s));
            }
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        String test1 = "1 2 + 3 *"; 
        System.out.println("Biểu thức hậu tố: " + test1);
        System.out.println("Kết quả: " + evaluate(test1)); 
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biểu thức hậu tố (cách nhau bởi khoảng trắng): ");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println("Kết quả tính toán: " + evaluate(input));
        }
        scanner.close();
    }
}