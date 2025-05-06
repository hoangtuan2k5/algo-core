package io.github.hoangtuan2k5.datastructures.array;

/**
 * Lớp minh họa cho việc triển khai DynamicArray (Mảng Động).
 * <p>
 * Lớp này cung cấp phương thức main để trình bày cách sử dụng lớp DynamicArray
 * với các hoạt động và ví dụ khác nhau.
 * </p>
 * 
 * @author Hoàng Chiều Nguyễn Tuấn
 */
public class DynamicArrayDemo {
    /**
     * Phương thức main minh họa cách sử dụng lớp DynamicArray.
     * 
     * @param args Tham số dòng lệnh (không được sử dụng)
     */
    public static void main(String[] args) {
        System.out.println("Dynamic Array Demonstration");
        System.out.println("==========================");
        
        // Tạo mảng động các số nguyên với dung lượng ban đầu 2
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);
        System.out.println("Created dynamic array with initial capacity 2");
        System.out.println("Dynamic array is empty: " + dynamicArray.isEmpty());
        System.out.println("Dynamic array size: " + dynamicArray.size());
        
        // Thêm phần tử (thể hiện tự động thay đổi kích thước)
        System.out.println("\nAdding elements to demonstrate auto-resizing...");
        dynamicArray.append(10);
        System.out.println("After adding 10: " + dynamicArray + " (size: " + dynamicArray.size() + ")");
        dynamicArray.append(20);
        System.out.println("After adding 20: " + dynamicArray + " (size: " + dynamicArray.size() + ")");
        dynamicArray.append(30);  // Điều này sẽ kích hoạt thay đổi kích thước
        System.out.println("After adding 30: " + dynamicArray + " (size: " + dynamicArray.size() + ")");
        dynamicArray.append(40);
        System.out.println("After adding 40: " + dynamicArray + " (size: " + dynamicArray.size() + ")");
        
        // Lấy phần tử
        System.out.println("\nGetting elements:");
        System.out.println("Element at index 0: " + dynamicArray.get(0));
        System.out.println("Element at index 2: " + dynamicArray.get(2));
        
        // Đặt phần tử
        System.out.println("\nReplacing element at index 1...");
        dynamicArray.set(1, 25);
        System.out.println("After replacing: " + dynamicArray);
        
        // Xóa phần tử
        System.out.println("\nRemoving element at index 1...");
        dynamicArray.remove(1);
        System.out.println("After removal: " + dynamicArray + " (size: " + dynamicArray.size() + ")");
        
        // Hoán đổi các phần tử
        System.out.println("\nSwapping elements at indices 0 and 2...");
        dynamicArray.swap(0, 2);
        System.out.println("After swapping: " + dynamicArray);
        
        // Tạo bản sao
        System.out.println("\nCreating a copy of the array...");
        DynamicArray<Integer> copyArray = dynamicArray.copy();
        System.out.println("Original: " + dynamicArray);
        System.out.println("Copy: " + copyArray);
        
        // Sửa đổi bản sao để chứng minh tính độc lập
        System.out.println("\nModifying the copy...");
        copyArray.set(0, 99);
        System.out.println("Original after modifying copy: " + dynamicArray);
        System.out.println("Modified copy: " + copyArray);
        
        // Điền giá trị vào mảng
        System.out.println("\nFilling array with value 5...");
        dynamicArray.fill(5);
        System.out.println("After filling: " + dynamicArray);
        
        // Sử dụng bộ lặp
        System.out.println("\nIterating through the array:");
        for (Integer element : dynamicArray) {
            System.out.println("Element: " + element);
        }
        
        // Ví dụ mảng chuỗi
        System.out.println("\nString array example:");
        DynamicArray<String> stringArray = new DynamicArray<>(2);
        stringArray.append("Java");
        stringArray.append("Data Structures");
        stringArray.append("Algorithms");
        stringArray.append("Dynamic Arrays");
        System.out.println("String array: " + stringArray);
        
        // Xử lý ngoại lệ
        System.out.println("\nDemonstrating exception handling...");
        try {
            dynamicArray.get(10); // Điều này sẽ ném ra IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        try {
            new DynamicArray<>(-1); // Điều này sẽ ném ra IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("\nDynamic Array demonstration completed.");
    }
}