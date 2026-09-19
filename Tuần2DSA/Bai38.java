import java.util.Random;

public class Bai38 {

    // 1. Cài đặt ngây thơ (Naive)
    public static int countNaive(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (i < j && j < k) {
                        if (a[i] + a[j] + a[k] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    // 2. Cài đặt chuẩn (Standard)
    public static int countStandard(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


    public static void timeTrial(int N) {
        int[] a = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(2000000) - 1000000;
        }

        // Đo thời gian Naive
        long startTimeNaive = System.currentTimeMillis();
        countNaive(a);
        double timeNaive = (System.currentTimeMillis() - startTimeNaive) / 1000.0;

        // Đo thời gian Standard
        long startTimeStandard = System.currentTimeMillis();
        countStandard(a);
        double timeStandard = (System.currentTimeMillis() - startTimeStandard) / 1000.0;

        // Tránh lỗi chia cho 0 nếu thời gian chạy quá nhanh
        if (timeStandard == 0) timeStandard = 0.001; 
        
        double ratio = timeNaive / timeStandard;

        System.out.printf("%7d | %8.3f s | %8.3f s | %5.2f\n", N, timeNaive, timeStandard, ratio);
    }

    public static void main(String[] args) {
        System.out.println("N | Time Naive | Time Std | Ratio (Naive/Std)");
    
        // Nhân đôi N liên tục (Doubling Test)
        for (int N = 250; N <= 4000; N += N) {
            timeTrial(N);
        }
    }
}