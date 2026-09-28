public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N; 

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        if (isFull()) {
            throw new StackOverflowError("Stack đã đầy, không thể thêm phần tử mới!");
        }
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }
}