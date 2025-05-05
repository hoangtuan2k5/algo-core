package io.github.hoangtuan2k5.datastructures.array;

import junit.framework.TestCase;

/**
 * Các kiểm thử đơn vị cho việc triển khai StaticArray (Mảng Tĩnh).
 * 
 * @author Hoàng Chiều Nguyễn Tuấn
 */
public class StaticArrayTest extends TestCase {
    
    /**
     * Kiểm thử constructor và phương thức size của StaticArray.
     */
    public void testConstructorAndSize() {
        StaticArray<Integer> array = new StaticArray<>(5);
        assertEquals(5, array.size());
        
        StaticArray<String> emptyArray = new StaticArray<>(0);
        assertEquals(0, emptyArray.size());
        assertTrue(emptyArray.isEmpty());
        
        try {
            new StaticArray<>(-1);
            fail("expect an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Ngoại lệ được mong đợi
        }
    }
    
    /**
     * Kiểm thử phương thức get và set của StaticArray.
     */
    public void testGetAndSet() {
        StaticArray<String> array = new StaticArray<>(3);
        
        array.set(0, "A");
        array.set(1, "B");
        array.set(2, "C");
        
        assertEquals("A", array.get(0));
        assertEquals("B", array.get(1));
        assertEquals("C", array.get(2));
        
        array.set(1, "D");
        assertEquals("D", array.get(1));
        
        try {
            array.get(3);
            fail("expect an IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
        
        try {
            array.set(-1, "X");
            fail("expect an IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Ngoại lệ được mong đợi
        }
    }
    
    /**
     * Kiểm thử phương thức contains và indexOf của StaticArray.
     */
    public void testContainsAndIndexOf() {
        StaticArray<Integer> array = new StaticArray<>(4);
        
        array.set(0, 10);
        array.set(1, 20);
        array.set(2, null);
        array.set(3, 30);
        
        assertTrue(array.contains(10));
        assertTrue(array.contains(20));
        assertTrue(array.contains(null));
        assertTrue(array.contains(30));
        assertFalse(array.contains(40));
        
        assertEquals(0, array.indexOf(10));
        assertEquals(1, array.indexOf(20));
        assertEquals(2, array.indexOf(null));
        assertEquals(3, array.indexOf(30));
        assertEquals(-1, array.indexOf(40));
    }
    
    /**
     * Kiểm thử phương thức fill và clear của StaticArray.
     */
    public void testFillAndClear() {
        StaticArray<Integer> array = new StaticArray<>(3);
        
        array.fill(42);
        assertEquals(Integer.valueOf(42), array.get(0));
        assertEquals(Integer.valueOf(42), array.get(1));
        assertEquals(Integer.valueOf(42), array.get(2));
        
        array.clear();
        assertNull(array.get(0));
        assertNull(array.get(1));
        assertNull(array.get(2));
    }
    
    /**
     * Kiểm thử phương thức swap và reverse của StaticArray.
     */
    public void testSwapAndReverse() {
        StaticArray<Character> array = new StaticArray<>(5);
        
        array.set(0, 'A');
        array.set(1, 'B');
        array.set(2, 'C');
        array.set(3, 'D');
        array.set(4, 'E');
        
        array.swap(0, 4);
        assertEquals(Character.valueOf('E'), array.get(0));
        assertEquals(Character.valueOf('A'), array.get(4));
        
        array.swap(1, 3);
        assertEquals(Character.valueOf('D'), array.get(1));
        assertEquals(Character.valueOf('B'), array.get(3));
        
        // Bây giờ mảng là ['E', 'D', 'C', 'B', 'A']
        array.reverse();
        // Sau khi đảo ngược: ['A', 'B', 'C', 'D', 'E']
        
        assertEquals(Character.valueOf('A'), array.get(0));
        assertEquals(Character.valueOf('B'), array.get(1));
        assertEquals(Character.valueOf('C'), array.get(2));
        assertEquals(Character.valueOf('D'), array.get(3));
        assertEquals(Character.valueOf('E'), array.get(4));
    }
    
    /**
     * Kiểm thử phương thức copy của StaticArray.
     */
    public void testCopy() {
        StaticArray<String> original = new StaticArray<>(3);
        original.set(0, "X");
        original.set(1, "Y");
        original.set(2, "Z");
        
        StaticArray<String> copy = original.copy();
        
        assertEquals(original.size(), copy.size());
        assertEquals(original.get(0), copy.get(0));
        assertEquals(original.get(1), copy.get(1));
        assertEquals(original.get(2), copy.get(2));
        
        // Đảm bảo chúng là các thực thể riêng biệt
        copy.set(0, "has been modified");
        assertEquals("X", original.get(0));
        assertEquals("has been modified", copy.get(0));
    }
    
    /**
     * Kiểm thử phương thức toString của StaticArray.
     */
    public void testToString() {
        StaticArray<Integer> array = new StaticArray<>(3);
        array.set(0, 1);
        array.set(1, 2);
        array.set(2, 3);
        
        assertEquals("[1, 2, 3]", array.toString());
        
        StaticArray<String> emptyArray = new StaticArray<>(0);
        assertEquals("[]", emptyArray.toString());
    }
}
