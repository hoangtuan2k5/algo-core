package io.github.hoangtuan2k5.datastructures.array;

import java.util.Arrays;
import java.util.Iterator;

/**
 * mảng động (Dynamic Array).
 * <p>
 * Lớp này bọc một mảng nguyên thủy Java và cung cấp khả năng tự động thay đổi kích thước
 * cùng với các thao tác mảng thông dụng. Không giống như mảng tĩnh,
 * mảng động có thể tăng kích thước khi cần thiết khi thêm phần tử.
 * </p>
 * <p>
 * Mảng tự động tăng gấp đôi dung lượng khi đạt đến giới hạn.
 * </p>
 *
 * @author Hoàng Chiều Nguyễn Tuấn
 * @param <T> Kiểu dữ liệu của các phần tử được lưu trữ trong mảng
 */
public class DynamicArray<T> implements Iterable<T> {
    private T[] array;
    private int size;
    private int capacity;

    /**
     * Tạo một mảng động mới với dung lượng ban đầu được chỉ định.
     *
     * @param initialCapacity Dung lượng ban đầu của mảng
     * @throws IllegalArgumentException Nếu dung lượng ban đầu là số âm
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative. Capacity: " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }
    
    /**
     * Thêm một phần tử vào cuối mảng.
     * <p>
     * Nếu mảng đã đầy, nó sẽ tự động thay đổi kích thước để chứa phần tử mới.
     * </p>
     *
     * @param element Phần tử được thêm vào mảng
     */
    public void append(T element) {
        if (size == capacity) {
            resize();
        }
        array[size++] = element;
    }

    /**
     * Trả về phần tử tại vị trí chỉ định trong mảng này.
     *
     * @param index Chỉ số của phần tử cần trả về
     * @return Phần tử tại vị trí chỉ định
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi
     */
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    /**
     * Thay thế phần tử tại vị trí chỉ định trong mảng này.
     *
     * @param index Chỉ số của phần tử cần thay thế
     * @param element Phần tử được lưu trữ tại vị trí chỉ định
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi
     */
    public void set(int index, T element) {
        validateIndex(index);
        array[index] = element;
    }

    /**
     * Xóa phần tử tại vị trí chỉ định trong mảng này.
     * <p>
     * Dịch chuyển các phần tử tiếp theo sang trái, giảm chỉ số của chúng đi một.
     * </p>
     *
     * @param index Chỉ số của phần tử cần xóa
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi
     */
    public void remove(int index) {
        validateIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    /**
     * Xóa tất cả các phần tử trong mảng này.
     * <p>
     * Các phần tử trong mảng sẽ được đặt thành null, nhưng dung lượng của mảng không thay đổi.
     * </p>
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
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
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * Trả về một bản sao của mảng động này.
     *
     * @return Một mảng động mới với các phần tử giống mảng cũ
     */
    @SuppressWarnings("unchecked")
    public DynamicArray<T> copy() {
        DynamicArray<T> newArray = new DynamicArray<>(capacity);
        newArray.size = this.size;
        newArray.capacity = this.capacity;
        System.arraycopy(array, 0, newArray.array, 0, capacity);
        return newArray;
    }

    /**
     * Điền mảng với phần tử chỉ định.
     * <p>
     * Phương thức này chỉ ảnh hưởng đến kích thước hiện tại của mảng, không phải dung lượng của nó.
     * </p>
     *
     * @param element Phần tử dùng để điền vào mảng
     */
    public void fill(T element) {
        for(int i = 0; i < size; i++) {
            array[i] = element;
        }
    }

    /**
     * Hoán đổi các phần tử tại các vị trí chỉ định trong mảng này.
     *
     * @param i Chỉ số của một phần tử cần hoán đổi
     * @param j Chỉ số của phần tử khác cần hoán đổi
     * @throws IndexOutOfBoundsException Nếu một trong hai chỉ số nằm ngoài phạm vi
     */
    public void swap(int i, int j) {
        validateIndex(i);
        validateIndex(j);
        
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Trả về số lượng phần tử trong mảng này.
     *
     * @return Số lượng phần tử trong mảng này
     */
    public int size() {
        return size;
    }

    /**
     * Trả về true nếu mảng này không chứa phần tử nào.
     *
     * @return true nếu mảng này không chứa phần tử nào
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Trả về true nếu mảng này chứa phần tử đã chỉ định.
     *
     * @param element Phần tử cần kiểm tra
     * @return true nếu mảng này chứa phần tử đã chỉ định, false nếu không
     */
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    /**
     * Xác thực rằng chỉ số chỉ định nằm trong phạm vi [0, capacity-1].
     *
     * @param index Chỉ số cần xác thực
     * @throws IndexOutOfBoundsException Nếu chỉ số nằm ngoài phạm vi
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("index: " + index + ", capacity: " + capacity);
        }
    }

    /**
     * Tăng gấp đôi dung lượng của mảng này.
     */
    private void resize() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }

    /**
     * Trả về một biểu diễn chuỗi của mảng này.
     *
     * @return Biểu diễn chuỗi của mảng này
     */
    @Override
    public String toString() {
        if(size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size - 1; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }
        sb.append(array[size - 1]);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Trả về một bộ lặp (iterator) cho các phần tử trong mảng này.
     *
     * @return Một bộ lặp cho các phần tử trong mảng này
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            
            @Override
            public boolean hasNext() {
                return currentIndex < size;
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
