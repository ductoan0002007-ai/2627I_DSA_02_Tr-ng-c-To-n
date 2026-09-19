import java.util.Random;

public class Bai40 {

    public static int countActual(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void runExperiment(int N, int M) {
        int[] a = new int[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(2 * M + 1) - M;
        }

        long startTime = System.currentTimeMillis();
        int actualCount = countActual(a);
        double timeTaken = (System.currentTimeMillis() - startTime) / 1000.0;

        double expectedCount = ((double) N * N * N) / (16.0 * M);

        System.out.printf("N = %-5d | M = %-8d || Thực tế: %-5d | Dự đoán (Toán): %-7.1f | Thời gian: %.2fs\n", 
                          N, M, actualCount, expectedCount, timeTaken);
    }

    public static void main(String[] args) {
        int M = 1000000; 
        
        System.out.println("Bắt đầu thẩm định công thức N^3 / (16M)...");
    
        runExperiment(1000, M);
        runExperiment(2000, M);
        runExperiment(3000, M);
        runExperiment(4000, M); 
    }
}