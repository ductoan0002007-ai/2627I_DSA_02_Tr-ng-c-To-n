//LocalMinimum
public class Bai18 {

    public static int findLocalMinimum(int[] a) {
        int n = a.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        
        if (a[n - 1] < a[n - 2]) return n - 1;

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                return mid; 
            }
            
            if (a[mid - 1] < a[mid]) {
                right = mid - 1;
            } 
            
            else {
                left = mid + 1;
            }
        }

        return -1;
    } 
    public static void main(String[] args) {
        int[] arr = {9, 6, 3, 14, 5, 7, 4, -2, 8};
        int localMinIndex = findLocalMinimum(arr);
        System.out.println("Cực tiểu địa phương nằm ở chỉ số: " + localMinIndex);
        System.out.println("Giá trị cực tiểu: " + arr[localMinIndex]);
    }
}