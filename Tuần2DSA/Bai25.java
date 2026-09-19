//TwoEggProblem
public class Bai25 {

    /**
     * Phương pháp 1: Sử dụng công thức toán học (Tối ưu nhất - O(1))
     * Tìm số x nhỏ nhất sao cho tổng cấp số cộng x + (x-1) + ... + 1 >= N
     * Tức là: x * (x + 1) / 2 >= N  => x^2 + x - 2N >= 0
     */
    public static int getMinDropsMath(int n) {
        if (n <= 0) return 0;
        // Giải phương trình bậc 2 lấy nghiệm dương
        return (int) Math.ceil((-1.0 + Math.sqrt(1 + 8.0 * n)) / 2.0);
    }

    
    public static int getMinDropsDP(int n) {
        if (n <= 0) return 0;
        
        int[] dp = new int[n + 1];
        
        // Base cases: 0 tầng cần 0 lần, 1 tầng cần 1 lần thả
        dp[0] = 0;
        dp[1] = 1;
        
        // Tính toán cho các tầng từ 2 đến N
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            // Thử thả quả trứng thứ nhất tại từng tầng x (từ 1 đến i)
            for (int x = 1; x <= i; x++) {
                // Trường hợp 1: Trứng vỡ tại tầng x 
                // -> Còn 1 quả, phải dò tuyến tính từ dưới lên (cần x - 1 lần nữa)
                int broken = x - 1;
                
                // Trường hợp 2: Trứng không vỡ tại tầng x 
                // -> Còn 2 quả, số tầng còn lại phải kiểm tra là (i - x)
                int survived = dp[i - x];
                
                // Chọn trường hợp xấu nhất giữa vỡ và không vỡ
                int worstCase = 1 + Math.max(broken, survived);
                
                // Tìm chiến lược (tầng x) cho ra số lần thả ít nhất
                dp[i] = Math.min(dp[i], worstCase);
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        int floors = 100; // Tòa nhà 100 tầng
        
        System.out.println("Số tầng của tòa nhà: " + floors);
        System.out.println("Số lần thả tối thiểu (Toán học)    : " + getMinDropsMath(floors));
        System.out.println("Số lần thả tối thiểu (Quy hoạch động): " + getMinDropsDP(floors));
        
        // In thử các mốc tầng cần thả quả thứ nhất theo chiến lược tối ưu
        System.out.print("Chiến lược thả quả thứ nhất (các tầng): ");
        int step = getMinDropsMath(floors);
        int currentFloor = 0;
        while (step > 0 && currentFloor < floors) {
            currentFloor += step;
            if (currentFloor > floors) currentFloor = floors;
            System.out.print(currentFloor + (currentFloor == floors ? "" : " -> "));
            step--;
        }
        System.out.println();
    }
}