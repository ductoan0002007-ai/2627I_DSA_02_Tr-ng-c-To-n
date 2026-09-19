import java.util.Arrays;
//ClosestPair
public class Bai16 {
    public static void findClosestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Mảng cần ít nhất 2 phần tử.");
            return;
        }

        Arrays.sort(a);

        double minDiff = Double.MAX_VALUE;
        double num1 = 0;
        double num2 = 0;

        for (int i = 0; i < a.length - 1; i++) {
            double currentDiff = a[i + 1] - a[i]; 
            
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                num1 = a[i];
                num2 = a[i + 1];
            }
        }

        System.out.println("Cặp số gần nhất là: " + num1 + " và " + num2);
        System.out.println("Khoảng cách (hiệu tuyệt đối): " + minDiff);
    }

    public static void main(String[] args) {
        double[] arr = {10.5, 2.1, -3.5, 4.8, 15.2, 5.0};
        findClosestPair(arr);
    }
}