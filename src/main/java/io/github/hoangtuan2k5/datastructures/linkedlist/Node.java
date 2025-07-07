package io.github.hoangtuan2k5.datastructures.linkedlist;

/**
 * Đại diện cho một node trong danh sách liên kết đôi.
 * 
 * @param <T> Kiểu dữ liệu được lưu trữ trong node
 * @author hoangtuan2k5
 */
class Node<T> {
    // Các trường và phương thức
    
    /**
     * Giá trị dữ liệu của node
     */
    private T data;
    
    /**
     * Node liên kết trước trong danh sách liên kết
     */
    private Node<T> prev;
    
    /**
     * Node liên kết kế tiếp trong danh sách liên kết
     */
    private Node<T> next;
    
    /**
     * Khởi tạo một node mới với dữ liệu và các liên kết xác định
     * 
     * @param data Dữ liệu để lưu trữ trong node
     * @param prev node trước nút này trong danh sách liên kết
     * @param next node kế tiếp nút này trong danh sách liên kết
     */
    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    
    /**
     * Lấy dữ liệu được lưu trữ trong node
     * 
     * @return Dữ liệu được lưu trữ
     */
    public T getData() {
        return data;
    }
    
    /**
     * Đặt dữ liệu mới cho node
     * 
     * @param data Dữ liệu mới để lưu trữ
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Lấy node trước trong danh sách liên kết
     * 
     * @return node trước, hoặc null nếu đây là nút đầu tiên
     */
    public Node<T> getPrev() {
        return prev;
    }
    
    /**
     * Đặt node trước trong danh sách liên kết
     * 
     * @param prev node trước mới
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    /**
     * Lấy node kế tiếp trong danh sách liên kết
     * 
     * @return node kế tiếp, hoặc null nếu đây là nút cuối cùng
     */
    public Node<T> getNext() {
        return next;
    }
    
    /**
     * Đặt node kế tiếp trong danh sách liên kết
     * 
     * @param next node kế tiếp mới
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    /**
     * Chuyển đổi node thành chuỗi, trả về biểu diễn chuỗi của dữ liệu
     * 
     * @return Biểu diễn chuỗi của node
     */
    @Override
    public String toString() {
        return data == null ? "null" : data.toString();
    }
}