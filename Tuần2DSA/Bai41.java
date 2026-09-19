import java.util.Random;

//TimeEstimator
public class Bai41 {

    public static int threeSum(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) count++;
                }
            }
        }
        return count;
    }

    public static int[] generateRandomArray(int N) {
        int[] a = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(2000000) - 1000000;
        }
        return a;
    }

    public static void main(String[] args) {
        int smallN = 4000;          
        int targetN = 1000000;    

        System.out.println("1. Đang chạy đo đạc thực tế với N = " + smallN + "...");
        int[] a = generateRandomArray(smallN);
        
        long startTime = System.currentTimeMillis();
        threeSum(a);
        double actualTime = (System.currentTimeMillis() - startTime) / 1000.0;
        
        System.out.printf("=> Thời gian chạy thực tế cho %d số là: %.3f giây\n\n", smallN, actualTime);

        System.out.println("2. Bắt đầu tính toán ngoại suy cho N = " + targetN + "...");
        
        
        double K = (double) targetN / smallN; 
        
        double estimatedTwoSum = actualTime * (0.01) * Math.pow(K, 2); // Giả định TwoSum nhanh bằng 1/100 ThreeSum

        double estimatedThreeSum = actualTime * Math.pow(K, 3);

        double hoursThreeSum = estimatedThreeSum / 3600.0;
        double daysThreeSum = hoursThreeSum / 24.0;

        System.out.println("---------------------------------------------------");
        System.out.printf("Dự đoán TwoSum (O(N^2)):     %,.2f giây\n", estimatedTwoSum);
        System.out.printf("Dự đoán ThreeSum (O(N^3)):   %,.2f giây (~ %.1f giờ, hay %.1f ngày)\n", 
                          estimatedThreeSum, hoursThreeSum, daysThreeSum);
        System.out.println("---------------------------------------------------");
    }
}