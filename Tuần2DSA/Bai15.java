import java.util.Arrays;

public class Bai15 {
    public static void findThreeSum(int[] a) {
        // BƯỚC 1: Bắt buộc phải sắp xếp mảng
        Arrays.sort(a);
        int n = a.length;

        // BƯỚC 2: Duyệt từng phần tử làm chốt
        for (int i = 0; i < n - 2; i++) {
            // Bỏ qua nếu giá trị chốt bị trùng lặp (tránh in ra kết quả giống nhau)
            if (i > 0 && a[i] == a[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;
            int target = -a[i];

            // BƯỚC 3: Áp dụng thuật toán Two Pointers
            while (left < right) {
                int sum = a[left] + a[right];

                if (sum == target) {
                    System.out.println(a[i] + " " + a[left] + " " + a[right]);
                    
                    // Bỏ qua các phần tử trùng lặp để không in 1 kết quả 2 lần
                    while (left < right && a[left] == a[left + 1]) left++;
                    while (left < right && a[right] == a[right - 1]) right--;
                    
                    // Tiếp tục tìm các cặp khác cho cùng chốt i
                    left++;
                    right--;
                } 
                else if (sum < target) {
                    left++; // Cần số lớn hơn
                } 
                else {
                    right--; // Cần số nhỏ hơn
                }
            }
        }
    }
}