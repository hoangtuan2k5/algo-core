package io.github.hoangtuan2k5.datastructures.array;

import java.util.Iterator;

/**
 * Lớp triển khai mảng tĩnh (Static Array) có hỗ trợ kiểu dữ liệu tổng quát.
 * <p>
 * Lớp này bọc một mảng Java nguyên thủy với kích thước cố định và cung cấp
 * các phương thức cho các hoạt động thông dụng như lấy dữ liệu, gán dữ liệu, v.v.
 * </p>
 * <p>
 * Không giống như mảng động (Dynamic Array trong Java), kích thước của mảng tĩnh không thể
 * thay đổi sau khi khởi tạo.
 * </p>
 * 
 * @author Hoàng Chiều Nguyễn Tuấn
 * @param <T> Kiểu dữ liệu của các phần tử được lưu trữ trong mảng
 */
public class StaticArray<T> implements Iterable<T> {
    private final T[] array;
    private final int capacity;
    
    /**
     * Tạo một StaticArray mới với dung lượng đã chỉ định.
     * 
     * @param capacity Kích thước cố định của mảng
     * @throws IllegalArgumentException Nếu dung lượng là số âm
     */
    @SuppressWarnings("unchecked")
    public StaticArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative. Capacity: " + capacity);
        }
        
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }
    
    /**
     * Trả về phần tử tại vị trí chỉ định trong mảng này.
     * 
     * @param index Chỉ số của phần tử để trả về
     * @return Phần tử tại vị trí chỉ định
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi hợp lệ
     */
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }
    
    /**
     * Đặt phần tử tại vị trí chỉ định trong mảng này.
     * 
     * @param index Chỉ số của phần tử cần thay thế
     * @param element Phần tử được lưu trữ tại vị trí chỉ định
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi hợp lệ
     */
    public void set(int index, T element) {
        validateIndex(index);
        array[index] = element;
    }
    
    /**
     * Xóa tất cả các phần tử trong mảng bằng cách đặt chúng thành null.
     */
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
    }
    
    /**
     * Điền vào mảng với phần tử đã chỉ định.
     * 
     * @param element Phần tử để điền vào mảng
     */
    public void fill(T element) {
        for (int i = 0; i < capacity; i++) {
            array[i] = element;
        }
    }
    
    /**
     * Trả về chỉ số của lần xuất hiện đầu tiên của phần tử đã chỉ định,
     * hoặc -1 nếu mảng này không chứa phần tử.
     * 
     * @param element Phần tử cần tìm kiếm
     * @return Chỉ số của lần xuất hiện đầu tiên của phần tử đã chỉ định,
     *         hoặc -1 nếu mảng này không chứa phần tử
     */
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < capacity; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * Trả về true nếu mảng này chứa phần tử đã chỉ định.
     * 
     * @param element Phần tử cần kiểm tra sự hiện diện trong mảng này
     * @return true nếu mảng này chứa phần tử đã chỉ định
     */
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }
    
    /**
     * Trả về số lượng phần tử trong mảng này (dung lượng của nó).
     * 
     * @return Số lượng phần tử trong mảng này
     */
    public int size() {
        return capacity;
    }
    
    /**
     * Trả về true nếu mảng này không chứa phần tử nào.
     * 
     * @return true nếu mảng này không chứa phần tử nào
     */
    public boolean isEmpty() {
        return capacity == 0;
    }
    
    /**
     * Trả về biểu diễn chuỗi của mảng này.
     * 
     * @return Biểu diễn chuỗi của mảng này
     */
    @Override
    public String toString() {
        if (capacity == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < capacity - 1; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }
        sb.append(array[capacity - 1]);
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Hoán đổi các phần tử tại các vị trí chỉ định trong mảng này.
     * 
     * @param i Chỉ số của một phần tử được hoán đổi
     * @param j Chỉ số của phần tử khác được hoán đổi
     * @throws IndexOutOfBoundsException Nếu một trong hai chỉ số nằm ngoài phạm vi hợp lệ
     */
    public void swap(int i, int j) {
        validateIndex(i);
        validateIndex(j);
        
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * Đảo ngược thứ tự các phần tử trong mảng này.
     */
    public void reverse() {
        for (int i = 0; i < capacity / 2; i++) {
            swap(i, capacity - i - 1);
        }
    }
    
    /**
     * Xác thực rằng chỉ số đã chỉ định nằm trong phạm vi [0, capacity-1].
     * 
     * @param index Chỉ số cần xác thực
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi hợp lệ
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("index: " + index + ", capacity: " + capacity);
        }
    }
    
    /**
     * Trả về một bản sao của StaticArray này.
     * 
     * @return Một StaticArray mới với cùng các phần tử
     */
    public StaticArray<T> copy() {
        StaticArray<T> newArray = new StaticArray<>(capacity);
        System.arraycopy(array, 0, newArray.array, 0, capacity);
        return newArray;
    }

    /**
     * Trả về một Iterator cho mảng này.
     * 
     * @return Một Iterator cho mảng này
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < capacity;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("No more elements to iterate.");
                }
                return array[currentIndex++];
            }
        };
    }
}