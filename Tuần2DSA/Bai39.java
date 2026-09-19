import java.util.Random;

public class Bai39 {

    // Thuật toán 3-SUM chuẩn
    public static int countStandard(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) cnt++;
                }
            }
        }
        return cnt;
    }

    // Hàm đo thời gian được cải tiến: Chạy lặp lại 'trials' lần và lấy trung bình
    public static double timeTrial(int N, int trials) {
        double totalTime = 0.0;
        Random rand = new Random();

        for (int t = 0; t < trials; t++) {
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = rand.nextInt(2000000) - 1000000;
            }

            long startTime = System.currentTimeMillis();
            countStandard(a);
            long endTime = System.currentTimeMillis();

            totalTime += (endTime - startTime) / 1000.0;
        }

        return totalTime / trials;
    }

    public static void main(String[] args) {
        int trials = 100; 
        
        System.out.println("Đang chạy Doubling Ratio với T = " + trials + " lần thử/mức N");
        System.out.println("N | Thời gian TB (s) | Ratio (Tỷ lệ)");

        double prevTime = timeTrial(125, trials); 

        for (int N = 250; N <= 2000; N += N) {
            double time = timeTrial(N, trials);
            
            double ratio = (prevTime > 0) ? time / prevTime : 0.0;
            
            System.out.printf("%7d | %16.4f | %5.2f\n", N, time, ratio);
            prevTime = time;
        }
    }
}