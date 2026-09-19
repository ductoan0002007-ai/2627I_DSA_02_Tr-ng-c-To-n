import java.util.Arrays;
//MatrixLocalMinimum
public class Bai19 {

    // Hàm gọi chính từ bên ngoài
    public static int[] findLocalMinimum(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return new int[]{-1, -1};
        }
        
        int n = a.length;
        // Bắt đầu đệ quy tìm kiếm trên toàn bộ ma trận
        return search(a, 0, n - 1, 0, n - 1);
    }

    private static int[] search(int[][] a, int rowStart, int rowEnd, int colStart, int colEnd) {
        // Điều kiện dừng an toàn
        if (rowStart > rowEnd || colStart > colEnd) {
            return null;
        }

        int midRow = rowStart + (rowEnd - rowStart) / 2;
        int midCol = colStart + (colEnd - colStart) / 2;

        int minVal = Integer.MAX_VALUE;
        int minRow = -1;
        int minCol = -1;

        for (int c = colStart; c <= colEnd; c++) {
            if (a[midRow][c] < minVal) {
                minVal = a[midRow][c];
                minRow = midRow;
                minCol = c;
            }
        }

        for (int r = rowStart; r <= rowEnd; r++) {
            if (a[r][midCol] < minVal) {
                minVal = a[r][midCol];
                minRow = r;
                minCol = midCol;
            }
        }

        // 3. Kiểm tra xem phần tử nhỏ nhất trên chữ thập có phải là Cực tiểu địa phương không
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Trên, Dưới, Trái, Phải
        boolean isLocalMin = true;
        
        int nextRow = -1;
        int nextCol = -1;
        int smallestNeighborVal = minVal;

        for (int[] dir : directions) {
            int r = minRow + dir[0];
            int c = minCol + dir[1];

            // Chú ý: So sánh với toàn bộ giới hạn của ma trận gốc, không phải ma trận con
            if (r >= 0 && r < a.length && c >= 0 && c < a[0].length) {
                if (a[r][c] < smallestNeighborVal) {
                    smallestNeighborVal = a[r][c];
                    nextRow = r;
                    nextCol = c;
                    isLocalMin = false; // Có hàng xóm nhỏ hơn -> Không phải đáy
                }
            }
        }

        if (isLocalMin) {
            return new int[]{minRow, minCol};
        }

        // 5. Nếu không, đi theo con dốc (người hàng xóm nhỏ hơn) để vào 1 trong 4 góc phần tư
        if (nextRow < midRow && nextCol < midCol) {
            // Góc trên bên trái
            return search(a, rowStart, midRow - 1, colStart, midCol - 1);
        } else if (nextRow < midRow && nextCol > midCol) {
            // Góc trên bên phải
            return search(a, rowStart, midRow - 1, midCol + 1, colEnd);
        } else if (nextRow > midRow && nextCol < midCol) {
            // Góc dưới bên trái
            return search(a, midRow + 1, rowEnd, colStart, midCol - 1);
        } else {
            // Góc dưới bên phải
            return search(a, midRow + 1, rowEnd, midCol + 1, colEnd);
        }
    }

    public static void main(String[] args) {
        // Tạo một ma trận 5x5 làm ví dụ
        int[][] matrix = {
            { 30,  28,  32,  29,  31 },
            { 27,  15,  18,   9,  26 },
            { 35,  16,  25,  10,  36 },
            { 34,  14,  24,  12,  33 },
            { 37,  38,  39,  40,  41 }
        };

        int[] result = findLocalMinimum(matrix);
        
        if (result != null) {
            int r = result[0];
            int c = result[1];
            System.out.println("Tọa độ Cực tiểu địa phương: (" + r + ", " + c + ")");
            System.out.println("Giá trị tại đó: " + matrix[r][c]);
        } else {
            System.out.println("Không tìm thấy (Lỗi dữ liệu đầu vào)");
        }
    }
}