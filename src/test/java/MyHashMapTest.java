import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MyHashMapTest {
    private MyHashMap<String, Object> map;

    @Before
    public void Setup() {
        map = new MyHashMap<>(10);
    }

    @Test
    public void testAddEntry() {
        for (int i = 0; i < 10000; i++) {
            map.put("key"+i, Integer.valueOf(i));
        }
        for (int i = 0; i < 10000; i++) {
            assertEquals("MyHashMap.get(key) does not work properly", Integer.valueOf(i), map.get("key"+i));
        }
    }

    @Test
    public void testPuttingSameEntryShouldOverrideExistingValue() {
        map.put("three", 3);
        map.put("three", 5);
        assertEquals("MyHashMap.put(key, value) doesn't work properly when overriding values", 5, map.get("three"));
    }

    @Test
    public void testGetFromNonExistingKeyReturnsNull() {
        assertEquals("MyHashMap.get doesn't work properly", null, map.get("tst"));
    }

    @Test
    public void testIsEmpty() {
        assertEquals("MyHashMap.isEmpty doesn't work properly", true, map.isEmpty());
        map.put("test", 2);
        assertEquals("MyHashMap.isEmpty doesn't work properly", false, map.isEmpty());

    }
    
    @Test
    public void testRemove() {
        for (int i = 0; i < 20; i++) {
            map.put("key"+i, Integer.valueOf(i));
        }
        for (int i = 0; i < 20; i++) {
            map.remove("key" + i);
        }
        assertEquals("MyHashMap.remove doesn't work properly", 0, map.size());
    }

    @Test
    public void testCorrectMapSize() {
        for (int i = 0; i < 20; i++) {
            map.put("key"+i, Integer.valueOf(i));
        }
        assertEquals("MyHashMap.size does not work properly", 20, map.size());
    }
}
