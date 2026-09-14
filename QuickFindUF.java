package edu.princeton.cs.algs4;

public class QuickFindUF {
    // Mảng lưu trữ ID của các tập hợp
    private int[] id;

    // 1. Hàm khởi tạo (Constructor) - Cài đặt giá trị ban đầu
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // 2. Thao tác Find (Kiểm tra kết nối)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // 3. Thao tác Union (Gộp tập hợp)
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        // Đã cùng tập hợp rồi thì không cần làm gì cả
        if (pid == qid) return;

        // Duyệt toàn bộ mảng, đổi toàn bộ các phần tử có ID bằng pid thành qid
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    // 4. Hàm main dùng để chạy thực thi (Run)
    public static void main(String[] args) {
        int N = 10;
        QuickFindUF uf = new QuickFindUF(N);

        System.out.println("--- BẮT ĐẦU CHẠY THỬ THUẬT TOÁN QUICK FIND ---");

        uf.union(4, 3);
        System.out.println("Đã nối node 4 và 3");

        uf.union(3, 8);
        System.out.println("Đã nối node 3 và 8");

        uf.union(6, 5);
        System.out.println("Đã nối node 6 và 5");

        uf.union(9, 4);
        System.out.println("Đã nối node 9 và 4");

        uf.union(2, 1);
        System.out.println("Đã nối node 2 và 1");

        System.out.println("\n--- KẾT QUẢ KIỂM TRA MẠNG LƯỚI ---");
        // Kiểm tra kết nối 8-9 (Nên là true vì 8 nối với 3, 3 nối với 4, 4 nối với 9)
        System.out.println("Node 8 và 9 có thông nhau không? " + uf.connected(8, 9));

        // Kiểm tra kết nối 5-4 (Nên là false vì nằm ở 2 cụm khác biệt)
        System.out.println("Node 5 và 4 có thông nhau không? " + uf.connected(5, 4));
    }
}