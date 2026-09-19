import java.util.Random;

public class Bai44 {

    public static int runSingleExperiment(int N, Random rand) {
        boolean[] hasAppeared = new boolean[N];
        int count = 0;

        while (true) {
            int val = rand.nextInt(N);
            count++; 

            if (hasAppeared[val]) {
                return count; 
            }

            hasAppeared[val] = true;
        }
    }

    public static void main(String[] args) {
        int trials = 10000; 
        Random rand = new Random();

        System.out.println("Thẩm định giả thuyết Birthday Problem: ~√(πN / 2)");
        System.out.printf("%-10s | %-15s | %-15s\n", "N (Phạm vi)", "Thực tế đo được", "Toán học dự đoán");
    
        // Chạy thử với các mức N khác nhau
        int[] testValues = {365, 1000, 10000, 100000, 1000000};

        for (int N : testValues) {
            long totalCount = 0;

            for (int t = 0; t < trials; t++) {
                totalCount += runSingleExperiment(N, rand);
            }

            double actualAverage = (double) totalCount / trials;

            double expectedMath = Math.sqrt(Math.PI * N / 2.0);

            System.out.printf("%-10d | %-15.2f | %-15.2f\n", N, actualAverage, expectedMath);
        }
    }
}