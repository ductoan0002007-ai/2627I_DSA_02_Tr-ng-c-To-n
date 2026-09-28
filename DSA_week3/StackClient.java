import java.util.Stack; 
public class StackClient {

    public static Stack<String> copy(Stack<String> original) {
        Stack<String> temp = new Stack<>();
        Stack<String> result = new Stack<>();

        for (String s : original) {
            temp.push(s); 
        }
    
        while (!temp.isEmpty()) {
            result.push(temp.pop());
        }
        
        return result;
    }

    public static void main(String[] args) {
        Stack<String> root = new Stack<>();
        root.push("A");
        root.push("B");
        root.push("C"); 

        Stack<String> clonedStack = copy(root);

        System.out.println("Stack gốc còn nguyên vẹn không? " + !root.isEmpty());
        System.out.println("Rút từ Stack copy ra: ");
        while (!clonedStack.isEmpty()) {
            System.out.println(clonedStack.pop());
        }
    }
}