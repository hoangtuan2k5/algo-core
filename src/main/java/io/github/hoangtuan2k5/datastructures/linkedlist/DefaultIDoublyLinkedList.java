package io.github.hoangtuan2k5.datastructures.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Triển khai mặc định của giao diện {@link IDoublyLinkedList}.
 * <p>
 * Lớp này cung cấp một triển khai danh sách liên kết đôi cơ bản, hỗ trợ các thao tác
 * như thêm, xóa, và truy cập phần tử. Nó sử dụng các node {@link Node} để lưu trữ
 * dữ liệu và duy trì các liên kết đến các phần tử trước và sau.
 * </p>
 * <p>
 * Các thao tác thêm/xóa ở đầu hoặc cuối danh sách có độ phức tạp thời gian O(1),
 * trong khi các thao tác dựa trên chỉ số hoặc tìm kiếm có độ phức tạp O(n).
 * </p>
 *
 * @author Hoàng Chiều Nguyễn Tuấn
 * @param <T> Kiểu dữ liệu của các phần tử được lưu trữ trong danh sách
 */
public class DefaultIDoublyLinkedList<T> implements IDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Khởi tạo một danh sách liên kết đôi rỗng.
     */
    public DefaultIDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Xóa tất cả các phần tử khỏi danh sách này.
     * <p>
     * Danh sách sẽ trống sau khi gọi phương thức này.
     * </p>
     */
    @Override
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setData(null);
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Trả về số lượng phần tử trong danh sách này.
     *
     * @return số lượng phần tử trong danh sách
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Kiểm tra xem chỉ số có hợp lệ hay không.
     *
     * @param index chỉ số cần kiểm tra
     * @return true nếu chỉ số hợp lệ
     * @throws IndexOutOfBoundsException nếu chỉ số nằm ngoài phạm vi [0, size-1]
     */
    @Override
    public boolean validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        return true;
    }

    /**
     * Trả về {@code true} nếu danh sách này không chứa phần tử nào.
     *
     * @return {@code true} nếu danh sách này trống
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Thêm một phần tử vào cuối danh sách.
     * <p>
     * Phương thức này tương đương với {@link #addLast(Object)}.
     * </p>
     *
     * @param element phần tử cần thêm
     */
    @Override
    public void add(T element) {
        addLast(element);
    }

    /**
     * Chèn một phần tử vào đầu danh sách.
     *
     * @param element phần tử cần thêm
     */
    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element, null, head);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Thêm một phần tử vào cuối danh sách.
     *
     * @param element phần tử cần thêm
     */
    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, tail, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Lấy phần tử đầu tiên trong danh sách mà không xóa nó.
     *
     * @return phần tử đầu tiên trong danh sách
     * @throws NoSuchElementException nếu danh sách trống
     */
    @Override
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked list is empty!");
        }
        return head.getData();
    }

    /**
     * Lấy phần tử cuối cùng trong danh sách mà không xóa nó.
     *
     * @return phần tử cuối cùng trong danh sách
     * @throws NoSuchElementException nếu danh sách trống
     */
    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked list is empty!");
        }
        return tail.getData();
    }

    /**
     * Xóa và trả về phần tử đầu tiên từ danh sách.
     *
     * @return phần tử đã bị xóa
     * @throws NoSuchElementException nếu danh sách trống
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked list is empty!");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        return data;
    }

    /**
     * Xóa và trả về phần tử cuối cùng từ danh sách.
     *
     * @return phần tử đã bị xóa
     * @throws NoSuchElementException nếu danh sách trống
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Linked list is empty!");
        }
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.setNext(null);
        }
        return data;
    }

    /**
     * Xóa một node cụ thể khỏi danh sách.
     *
     * @param node node cần xóa
     * @return dữ liệu của node đã bị xóa
     * @throws NullPointerException nếu node là null
     */
    private T remove(Node<T> node) {
        if (node == null) {
            throw new NullPointerException("Node cannot be null!");
        }

        if (node == head) {
            return removeFirst();
        }
        if (node == tail) {
            return removeLast();
        }

        T data = node.getData();
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;

        // Giải phóng bộ nhớ
        node.setData(null);
        node.setPrev(null);
        node.setNext(null);

        return data;
    }

    /**
     * Xóa lần xuất hiện đầu tiên của một đối tượng cụ thể khỏi danh sách.
     *
     * @param object đối tượng cần xóa
     * @return {@code true} nếu một phần tử đã bị xóa
     */
    @Override
    public boolean remove(Object object) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (java.util.Objects.equals(object, currentNode.getData())) {
                remove(currentNode);
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * Xóa phần tử tại một chỉ số cụ thể.
     *
     * @param index chỉ số của phần tử cần xóa
     * @return phần tử đã bị xóa tại vị trí đó
     * @throws IndexOutOfBoundsException nếu chỉ số nằm ngoài phạm vi
     */
    @Override
    public T removeAt(int index) {
        validateIndex(index);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return remove(currentNode);
    }

    /**
     * Trả về chỉ số của lần xuất hiện đầu tiên của đối tượng đã chỉ định.
     *
     * @param object đối tượng cần tìm
     * @return chỉ số của lần xuất hiện đầu tiên, hoặc -1 nếu không tìm thấy
     */
    @Override
    public int indexOf(Object object) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (java.util.Objects.equals(object, currentNode.getData())) {
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    /**
     * Trả về {@code true} nếu danh sách này chứa phần tử đã chỉ định.
     *
     * @param object phần tử cần kiểm tra
     * @return {@code true} nếu danh sách chứa phần tử
     */
    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Trả về một biểu diễn chuỗi của danh sách.
     *
     * @return biểu diễn chuỗi của danh sách
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Trả về một iterator trên các phần tử trong danh sách này theo đúng thứ tự.
     *
     * @return một iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
