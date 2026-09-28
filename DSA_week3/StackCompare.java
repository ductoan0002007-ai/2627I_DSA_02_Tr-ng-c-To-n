import edu.princeton.cs.algs4.Stopwatch;

public class StackCompare {

    public static double timeArrayStack(int N) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        Stopwatch timer = new Stopwatch();
        
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            stack.pop();
        }
        
        return timer.elapsedTime();
    }

    public static double timeLinkedListStack(int N) {
        Stack<Integer> stack = new Stack<>(); 
        Stopwatch timer = new Stopwatch();
        
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            stack.pop();
        }
        
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        System.out.printf("%10s %15s %15s %15s\n", "N", "Time (Array)", "Time (Linked)", "Ratio (Arr/Lnk)");
     
        for (int N = 250; true; N += N) {
            double timeArray = timeArrayStack(N);
            double timeLinked = timeLinkedListStack(N);
          
            double ratio = 0.0;
            if (timeLinked > 0) {
                ratio = timeArray / timeLinked;
            }
            
            System.out.printf("%10d %15.3f %15.3f %15.3f\n", N, timeArray, timeLinked, ratio);
            
            if (N > 10000000) break;
        }
    }
}
