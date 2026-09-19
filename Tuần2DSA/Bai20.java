//BitonicSearch
public class Bai20 {

    public static int search(int[] a, int target) {
        int n = a.length;
        if (n == 0) return -1;

        int peak = findPeak(a);

        int index = ascendingBinarySearch(a, target, 0, peak);
        if (index != -1) {
            return index; 
        }


        return descendingBinarySearch(a, target, peak + 1, n - 1);
    }

    private static int findPeak(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (a[mid] < a[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; 
    }

    private static int ascendingBinarySearch(int[] a, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static int descendingBinarySearch(int[] a, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) return mid;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] bitonicArray = {1, 3, 8, 12, 20, 15, 9, 5, 2};
        int target = 9;
        
        int resultIndex = search(bitonicArray, target);
        System.out.println("Vị trí của " + target + " là: " + resultIndex);
    }
}