import java.util.Random;

public class Bai42 {

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

    public static int[] generateArray(int N) {
        int[] a = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(2000000) - 1000000;
        }
        return a;
    }

    public static void main(String[] args) {
        double maxTimeAllowed = 3600.0; 
        double previousTime = 0.0;
        
        System.out.println("Mục tiêu: Tìm P lớn nhất sao cho N = 2^P * 1000 chạy dưới 1 giờ.");
        System.out.println("  P |N| Thời gian (s) | Ratio | Trạng thái");
        System.out.println("-----------------------------------------------------------------");

        for (int P = 0; P < 20; P++) {
            int N = (int) Math.pow(2, P) * 1000;
            
            if (previousTime > 1.0) {
                double ratio = 8.0;
                double estimatedTime = previousTime * ratio;
                
                if (estimatedTime <= maxTimeAllowed) {
                    System.out.printf("%3d | %13d | %13.3f | %5.1f | (Ngoại suy Toán học)\n", 
                                      P, N, estimatedTime, ratio);
                    previousTime = estimatedTime;
                } else {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("CẢNH BÁO: Ở P = " + P + " (N = " + N + "), thời gian sẽ là " 
                                       + (int)(estimatedTime/3600) + " giờ " 
                                       + (int)((estimatedTime%3600)/60) + " phút!");
                    System.out.println("GIỚI HẠN TỐI ĐA: Bạn chỉ chạy được đến P = " + (P - 1));
                    break;
                }
            } 
            else {
                int[] a = generateArray(N);
                
                long startTime = System.currentTimeMillis();
                threeSum(a);
                double actualTime = (System.currentTimeMillis() - startTime) / 1000.0;
                
                double ratio = (previousTime == 0.0) ? 0.0 : actualTime / previousTime;
                
                System.out.printf("%3d | %13d | %13.3f | %5.1f | (Đo đạc thực tế)\n", 
                                  P, N, actualTime, ratio);
                
                previousTime = (actualTime < 0.001) ? 0.001 : actualTime;
            }
        }
    }
}