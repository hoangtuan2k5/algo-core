package io.github.hoangtuan2k5.datastructures.array;

import java.util.Iterator;

import junit.framework.TestCase;

/**
 * Các kiểm thử đơn vị cho việc triển khai DynamicArray (Mảng Động).
 * 
 * @author Hoàng Chiều Nguyễn Tuấn
 */
public class DynamicArrayTest extends TestCase {
    
    /**
     * Kiểm thử constructor và phương thức size của DynamicArray.
     */
    public void testConstructorAndSize() {
        DynamicArray<Integer> array = new DynamicArray<>(5);
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
        
        try {
            new DynamicArray<>(-1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }
    
    /**
     * Kiểm thử phương thức append của DynamicArray.
     */
    public void testAppend() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        
        array.append(10);
        assertEquals(1, array.size());
        assertEquals(Integer.valueOf(10), array.get(0));
        
        array.append(20);
        assertEquals(2, array.size());
        assertEquals(Integer.valueOf(20), array.get(1));
        
        // Kiểm thử tự động thay đổi kích thước
        array.append(30);
        assertEquals(3, array.size());
        assertEquals(Integer.valueOf(30), array.get(2));
        
        array.append(40);
        assertEquals(4, array.size());
        assertEquals(Integer.valueOf(40), array.get(3));
    }
    
    /**
     * Kiểm thử phương thức get và set của DynamicArray.
     */
    public void testGetAndSet() {
        DynamicArray<String> array = new DynamicArray<>(3);
        
        array.append("A");
        array.append("B");
        array.append("C");
        
        assertEquals("A", array.get(0));
        assertEquals("B", array.get(1));
        assertEquals("C", array.get(2));
        
        array.set(1, "D");
        assertEquals("D", array.get(1));
        
        try {
            array.get(3);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
        
        try {
            array.set(-1, "X");
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
    }
    
    /**
     * Kiểm thử phương thức remove của DynamicArray.
     */
    public void testRemove() {
        DynamicArray<String> array = new DynamicArray<>(3);
        
        array.append("A");
        array.append("B");
        array.append("C");
        
        array.remove(1); // Xóa "B"
        assertEquals(2, array.size());
        assertEquals("A", array.get(0));
        assertEquals("C", array.get(1));
        
        array.remove(0); // Xóa "A"
        assertEquals(1, array.size());
        assertEquals("C", array.get(0));
        
        array.remove(0); // Xóa "C"
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
        
        try {
            array.remove(0);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
    }
    
    /**
     * Kiểm thử phương thức fill của DynamicArray.
     */
    public void testFill() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        
        array.append(1);
        array.append(2);
        array.append(3);
        
        array.fill(42);
        assertEquals(Integer.valueOf(42), array.get(0));
        assertEquals(Integer.valueOf(42), array.get(1));
        assertEquals(Integer.valueOf(42), array.get(2));
    }
    
    /**
     * Kiểm thử phương thức swap của DynamicArray.
     */
    public void testSwap() {
        DynamicArray<Character> array = new DynamicArray<>(5);
        
        array.append('A');
        array.append('B');
        array.append('C');
        array.append('D');
        array.append('E');
        
        array.swap(0, 4);
        assertEquals(Character.valueOf('E'), array.get(0));
        assertEquals(Character.valueOf('A'), array.get(4));
        
        array.swap(1, 3);
        assertEquals(Character.valueOf('D'), array.get(1));
        assertEquals(Character.valueOf('B'), array.get(3));
        
        try {
            array.swap(0, 10);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
    }
    
    /**
     * Kiểm thử phương thức copy của DynamicArray.
     */
    public void testCopy() {
        DynamicArray<String> original = new DynamicArray<>(3);
        original.append("X");
        original.append("Y");
        original.append("Z");
        
        DynamicArray<String> copy = original.copy();
        
        assertEquals(original.size(), copy.size());
        assertEquals(original.get(0), copy.get(0));
        assertEquals(original.get(1), copy.get(1));
        assertEquals(original.get(2), copy.get(2));
        
        // Đảm bảo chúng là các thực thể riêng biệt
        copy.set(0, "Modified");
        assertEquals("X", original.get(0));
        assertEquals("Modified", copy.get(0));
    }
    
    /**
     * Kiểm thử phương thức toString của DynamicArray.
     */
    public void testToString() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.append(1);
        array.append(2);
        array.append(3);
        
        assertEquals("[1, 2, 3]", array.toString());
        
        DynamicArray<String> emptyArray = new DynamicArray<>(0);
        assertEquals("[]", emptyArray.toString());
    }
    
    /**
     * Kiểm thử giao diện Iterable và Iterator của DynamicArray.
     */
    public void testIterator() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.append(1);
        array.append(2);
        array.append(3);
        
        Iterator<Integer> iterator = array.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
        
        // Kiểm thử vòng for-each
        int sum = 0;
        for (Integer value : array) {
            sum += value;
        }
        assertEquals(6, sum);
    }
}