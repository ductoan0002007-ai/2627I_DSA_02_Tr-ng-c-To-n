import java.util.NoSuchElementException;
public class Peek{
    
public String peek() {
    if (isEmpty()) {
        throw new NoSuchElementException("Stack đang rỗng, không có phần tử để xem!");
    }
    return a[N - 1];
}
}