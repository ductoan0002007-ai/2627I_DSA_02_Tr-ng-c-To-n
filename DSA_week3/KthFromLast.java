import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KthFromLast {
    public static void main(String[] args) {
       
        if (args.length == 0) {
            System.out.println("Vui lòng truyền tham số k");
            return;
        }
        int k = Integer.parseInt(args[0]);
        
        Queue<String> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nhập văn bản (Bấm Ctrl+D hoặc Ctrl+Z để kết thúc):");
        
        while (scanner.hasNext()) {
            String word = scanner.next();
            queue.add(word); 
            
            if (queue.size() > k) {
                queue.remove(); 
            }
        }
        
        if (queue.size() == k) {
            System.out.println("Phần tử thứ " + k + " từ dưới lên là: " + queue.peek());
        } else {
            System.out.println("Văn bản nhập vào có ít hơn " + k + " từ.");
        }
        
        scanner.close();
    }
}