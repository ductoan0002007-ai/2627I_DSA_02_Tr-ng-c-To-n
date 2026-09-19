//Binary search for a fraction
public class Bai23 {

    static class Oracle {
        private final int p;
        private final int q;

        public Oracle(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public boolean isLessThan(double x) {
            return ((double) p / q) < x;
        }
    }

    public static void findFraction(int N, Oracle oracle) {
        double left = 0.0;
        double right = 1.0;

        int maxQueries = (int) Math.ceil(2 * (Math.log(N) / Math.log(2))) + 1;
        System.out.println("Giới hạn N = " + N + ". Bắt đầu tìm kiếm với tối đa " + maxQueries + " câu hỏi...");

        for (int i = 1; i <= maxQueries; i++) {
            double mid = left + (right - left) / 2.0;

            if (oracle.isLessThan(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        double approximateValue = left;
        double threshold = 1.0 / (N * N);

        for (int q = 2; q < N; q++) {
            
            int p = (int) Math.round(approximateValue * q);
            
            double fractionValue = (double) p / q;
            
            // Nếu sai số giữa nó và giá trị ta tìm được nhỏ hơn khoảng cách 1/N^2 
            // Thì CHẮC CHẮN 100% đây chính là phân số bí mật!
            if (Math.abs(fractionValue - approximateValue) <= threshold) {
                System.out.println("🎉 Đã tìm thấy phân số bí mật: " + p + "/" + q);
                return;
            }
        }
        System.out.println("Không tìm thấy phân số nào hợp lệ.");
    }

    public static void main(String[] args) {
        int N = 100; 
        
        Oracle oracle = new Oracle(17, 73); 
        
       
        findFraction(N, oracle);
    }
}