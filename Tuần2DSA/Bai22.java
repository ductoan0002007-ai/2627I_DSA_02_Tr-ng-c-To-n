//FibonacciSearch
public class Bai22 {

    public static int searchDescending(int[] a, int target) {
        int n = a.length;
        if (n == 0) return -1;

        int f2 = 0; 
        int f1 = 1; 
        int f = f2 + f1; 

        while (f < n) {
            f2 = f1;
            f1 = f;
            f = f2 + f1; 
        }

        int offset = -1; 

        while (f > 1) {
            
            int i = offset + f2;
            if (i >= n) i = n - 1;

            if (a[i] == target) {
                return i;
            }

            if (a[i] < target) {
                f = f2;
                f1 = f1 - f2; 
                f2 = f - f1;
            } 
           
            else {
                offset = i; 
                f = f1;
                f1 = f2;
                f2 = f - f1; 
            }
        }

        if (f1 == 1 && offset + 1 < n && a[offset + 1] == target) {
            return offset + 1;
        }

        return -1; 
    }

    public static void main(String[] args) {
        
        int[] arr = {80, 55, 34, 21, 13, 8, 5, 3, 2, 1};
        int target = 21;
        
        System.out.println("Vị trí của " + target + " là: " + searchDescending(arr, target));
    }
}
