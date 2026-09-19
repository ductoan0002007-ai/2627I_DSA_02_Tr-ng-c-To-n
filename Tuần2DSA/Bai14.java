
    /*Khởi tạo: Tạo một Hash Table (ví dụ HashMap<Integer, List<Pair>> trong Java) để lưu trữ (tổng_hai_số -> danh sách các cặp chỉ số có tổng đó).
    Duyệt từng cặp (i, j): Dùng 2 vòng lặp lồng nhau duyệt qua tất cả các cặp phần tử a[i] và a[j] (với $i < j$).
    Tìm kiếm đối trọng:Tính sum = a[i] + a[j].Tính giá trị cần tìm target_sum = 0 - sum.
    Kiểm tra xem target_sum đã tồn tại trong Hash Table chưa.
    Ghép cặp & Kiểm tra hợp lệ:Nếu có, duyệt qua danh sách các cặp chỉ số (k, l) trong Hash Table có tổng bằng target_sum.
    Kiểm tra điều kiện bắt buộc: 4 chỉ số $i, j, k, l$ phải hoàn toàn khác nhau. (Vì mỗi phần tử ở một vị trí chỉ được dùng 1 lần).
    Nếu khác nhau, ta tìm được một bộ 4 số hợp lệ.
    Cập nhật Hash Table: Sau khi kiểm tra, thêm cặp (i, j) hiện tại vào Hash Table với khóa là sum để các vòng lặp sau có thể sử dụng. */
    
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class Bai14 {

    public static List<List<Integer>> findFourSum(int[] a, int target) {
        int n = a.length;
       
        Set<List<Integer>> result = new HashSet<>();
        
        Map<Integer, List<int[]>> map = new HashMap<>();

        // Bắt đầu từ i = 1 vì ta cần ít nhất 1 phần tử (k = 0) ở phía trước để đưa vào map
        for (int i = 1; i < n - 1; i++) {
            
            // BƯỚC 1: TÌM KIẾM ĐỐI TRỌNG (j chạy ở nửa sau: từ i + 1 đến cuối mảng)
            for (int j = i + 1; j < n; j++) {
                int currentSum = a[i] + a[j];
                int neededSum = target - currentSum;
                
                if (map.containsKey(neededSum)) {
                    for (int[] pair : map.get(neededSum)) {
                        
                        List<Integer> quad = Arrays.asList(a[pair[0]], a[pair[1]], a[i], a[j]);
                        
                        Collections.sort(quad);
                        result.add(quad);
                    }
                }
            }
            
            // BƯỚC 2: CẬP NHẬT HASHMAP (k chạy ở nửa trước: từ 0 đến i - 1)
            // Chỉ thêm các cặp kết thúc tại i vào map SAU KHI đã hoàn tất Bước 1
            for (int k = 0; k < i; k++) {
                int sum = a[k] + a[i];
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{k, i});
            }
        }

        // Chuyển kết quả từ Set sang List để trả về
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2, -1, 1};
        int target = 0; // Đặt target = 0 cho bài toán 4-Sum bằng 0
        
        List<List<Integer>> quadruplets = findFourSum(arr, target);
        
        System.out.println("Các bộ 4 số có tổng bằng " + target + " là:");
        for (List<Integer> quad : quadruplets) {
            System.out.println(quad);
        }
    }
}