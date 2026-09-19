//EggDrop
public class Bai24 {

    static class Building {
        private final int targetF;     // Tầng F (thả từ đây trở lên sẽ vỡ)
        public int dropCount = 0;      // Thống kê số lần đã thả
        public int brokenEggsCount = 0; // Thống kê số trứng đã vỡ

        public Building(int targetF) {
            this.targetF = targetF;
        }

        public boolean drop(int floor) {
            dropCount++;
            if (floor >= targetF) {
                brokenEggsCount++;
                return true;  
            }
            return false;    
        }
    }

    public static int findF(int N, Building building) {
        int currentFloor = 1;

        while (currentFloor < N && !building.drop(currentFloor)) {
            currentFloor *= 2;
        }

        int left = currentFloor / 2 + 1;
        int right = Math.min(currentFloor, N); 
        int exactF = right; 
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (building.drop(mid)) {
                exactF = mid;       
                right = mid - 1;    
            } else {
                left = mid + 1;
            }
        }

        return exactF;
    }

    public static void main(String[] args) {
        int N = 1000000; 
        int F = 30;     

        Building building = new Building(F);
        
        System.out.println("Bắt đầu thử nghiệm với tòa nhà " + N + " tầng...");
        int result = findF(N, building);
        
        System.out.println("🎉 Tìm thấy tầng F = " + result);
        System.out.println("📊 Thống kê chi phí:");
        System.out.println("- Số lần thả trứng (drops): " + building.dropCount);
        System.out.println("- Số trứng bị vỡ (broken): " + building.brokenEggsCount);
        
        int logF = (int) (Math.log(F) / Math.log(2)); 
        System.out.println("\n(So sánh với lý thuyết: 2 * log2(" + F + ") ≈ " + (2 * logF) + " lần thả)");
    }
}
