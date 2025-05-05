package io.github.hoangtuan2k5.datastructures.array;

/**
 * Lớp minh họa cho việc triển khai StaticArray (Mảng Tĩnh).
 * <p>
 * Lớp này cung cấp phương thức main trình bày cách sử dụng lớp StaticArray
 * với các hoạt động và ví dụ khác nhau.
 * </p>
 * 
 * @author Hoàng Chiều Nguyễn Tuấn
 */
public class StaticArrayDemo {
    /**
     * Phương thức main minh họa cách sử dụng lớp StaticArray.
     * 
     * @param args Tham số dòng lệnh (không được sử dụng)
     */
    public static void main(String[] args) {
        System.out.println("Static Array Demonstration");
        System.out.println("==================");
        
        // Tạo mảng tĩnh các số nguyên với dung lượng 5
        StaticArray<Integer> intArray = new StaticArray<>(5);
        System.out.println("Created static array with capacity 5: " + intArray);
        
        // Đặt các phần tử
        System.out.println("\nSetting elements...");
        intArray.set(0, 10);
        intArray.set(1, 20);
        intArray.set(2, 30);
        intArray.set(3, 40);
        intArray.set(4, 50);
        System.out.println("After setting elements: " + intArray);
        
        // Lấy phần tử
        System.out.println("\nGet element at index 2: " + intArray.get(2));
        
        // Kiểm tra nếu mảng chứa phần tử
        System.out.println("\nDoes array contain 30? " + intArray.contains(30));
        System.out.println("Does array contain 60? " + intArray.contains(60));
        
        // Tìm chỉ số của phần tử
        System.out.println("\nIndex of 40: " + intArray.indexOf(40));
        System.out.println("Index of 60: " + intArray.indexOf(60));
        
        // Hoán đổi các phần tử
        System.out.println("\nSwapping elements at indices 1 and 3...");
        intArray.swap(1, 3);
        System.out.println("After swapping: " + intArray);
        
        // Đảo ngược mảng
        System.out.println("\nReversing array...");
        intArray.reverse();
        System.out.println("After reversing: " + intArray);
        
        // Sao chép mảng
        System.out.println("\nCreating a copy of the array...");
        StaticArray<Integer> copyArray = intArray.copy();
        System.out.println("Original: " + intArray);
        System.out.println("Copy: " + copyArray);
        
        // Sửa đổi bản sao để chứng minh chúng độc lập
        System.out.println("\nModifying the copy...");
        copyArray.set(0, 99);
        System.out.println("Original after modifying the copy: " + intArray);
        System.out.println("Modified copy: " + copyArray);
        
        // Xóa mảng
        System.out.println("\nClearing the original array...");
        intArray.clear();
        System.out.println("After clearing: " + intArray);
        
        // Minh họa hoạt động điền giá trị
        System.out.println("\nFilling array with value 5...");
        intArray.fill(5);
        System.out.println("After filling: " + intArray);
        
        // Ví dụ mảng chuỗi
        StaticArray<String> stringArray = new StaticArray<>(3);
        System.out.println("\nString array example:");
        stringArray.set(0, "Java");
        stringArray.set(1, "Data Structures");
        stringArray.set(2, "Algorithms");
        System.out.println("String array: " + stringArray);
        
        // Minh họa xử lý ngoại lệ
        System.out.println("\nDemonstrating exception handling...");
        try {
            intArray.get(10); // Điều này sẽ ném ra IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        try {
            new StaticArray<>(-1); // Điều này sẽ ném ra IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("\nStatic Array demonstration completed.");
    }
}