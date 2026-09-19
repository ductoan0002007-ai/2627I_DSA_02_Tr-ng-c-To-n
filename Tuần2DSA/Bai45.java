import java.util.Random;
//CouponCollector
public class Bai45 {

    public static double harmonic(int N) {
        double sum = 0.0;
        for (int i = 1; i <= N; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static int runExperiment(int N, Random rand) {
        boolean[] collected = new boolean[N];
        int distinctCount = 0; 
        int steps = 0;         

       
        while (distinctCount < N) {
            int val = rand.nextInt(N); 
            steps++;

            if (!collected[val]) {
                collected[val] = true;
                distinctCount++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int trials = 1000; 
        Random rand = new Random();

        System.out.println("Thẩm định bài toán sưu tập thẻ (Coupon Collector)");
        System.out.printf("%-8s | %-15s | %-15s\n", "Tổng thẻ", "Thực tế đo được", "Toán học (N * H_N)");

        int[] testValues = {10, 100, 1000, 10000};

        for (int N : testValues) {
            long totalSteps = 0;

            for (int t = 0; t < trials; t++) {
                totalSteps += runExperiment(N, rand);
            }

            double actualAverage = (double) totalSteps / trials;

            double expectedMath = N * harmonic(N);

            System.out.printf("%-8d | %-15.2f | %-15.2f\n", N, actualAverage, expectedMath);
        }
    }
}