//FarthestPair
public class Bai17 {
    public static void findFarthestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Mảng cần ít nhất 2 phần tử.");
            return;
        }

        double min = a[0];
        double max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Cặp số xa nhất là: " + min + " và " + max);
        System.out.println("Khoảng cách lớn nhất (hiệu tuyệt đối): " + (max - min));
    }

    public static void main(String[] args) {
        double[] arr = {10.5, 2.1, -3.5, 4.8, 15.2, 5.0};
        findFarthestPair(arr);
    }
}