//Reduction3Sum
public class Bai26 {

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int countCollinearTriplets(Point[] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    Point p1 = points[i];
                    Point p2 = points[j];
                    Point p3 = points[k];

                    long lhs = (p2.y - p1.y) * (p3.x - p2.x);
                    long rhs = (p3.y - p2.y) * (p2.x - p1.x);

                    if (lhs == rhs) {
                        count++;
                        System.out.println("  -> Điểm thẳng hàng: (" 
                            + p1.x + ", " + p1.y + ") | (" 
                            + p2.x + ", " + p2.y + ") | (" 
                            + p3.x + ", " + p3.y + ")");
                        
                        System.out.println("  => Tương ứng 3-SUM: " 
                            + p1.x + " + " + p2.x + " + " + p3.x + " = 0\n");
                    }
                }
            }
        }
        return count;
    }

    public static void solve3SumUsingCollinearity(int[] a) {
        int n = a.length;
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            long x = a[i];
            long y = x * x * x; 
            points[i] = new Point(x, y);
        }

        System.out.println("Bắt đầu tìm kiếm...");
        int totalTriplets = countCollinearTriplets(points);
        
        System.out.println("Tổng số bộ ba thỏa mãn 3-SUM là: " + totalTriplets);
    }

    public static void main(String[] args) {
        int[] arr = {-3, 1, 2, 4, -5, 6, -1};
        
        solve3SumUsingCollinearity(arr);
    }
}
