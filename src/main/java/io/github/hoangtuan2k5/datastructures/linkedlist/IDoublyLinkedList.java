package io.github.hoangtuan2k5.datastructures.linkedlist;

/**
 * Interface cho triển khai danh sách liên kết đôi (Doubly Linked List).
 * <p>
 * Danh sách liên kết đôi là một cấu trúc dữ liệu tuyến tính trong đó mỗi phần tử (node)
 * chứa một tham chiếu đến cả phần tử trước và phần tử sau nó. Giao diện này định nghĩa
 * các thao tác cơ bản cho danh sách liên kết đôi như thêm, xóa, truy cập và tìm kiếm phần tử.
 * </p>
 * <p>
 * Danh sách liên kết đôi cung cấp khả năng thêm và xóa phần tử ở cả hai đầu với độ phức tạp thời gian O(1).
 * </p>
 *
 * @author hoangtuan2k5
 * @param <T> Kiểu dữ liệu của các phần tử trong danh sách liên kết
 */
public interface IDoublyLinkedList<T> extends Iterable<T> {
    // O(n)
    void clear();

    // constant
    int size();

    //constant
    boolean validateIndex(int index);

    // constant
    boolean isEmpty();

    // O(1)
    void add(T element);

    // O(1)
    void addFirst(T element);

    // O(1)
    void addLast(T element);

    // O(1)
    T peekFirst();

    // O(1)
    T peekLast();

    // O(1)
    T removeFirst();

    // O(1)
    T removeLast();

    // O(n)
    boolean remove(Object object);

    // O(n)
    T removeAt(int index);

    // O(n)
    int indexOf(Object object);

    // O(n)
    boolean contains(Object object);
}
