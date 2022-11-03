import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class MyStackTest {
    private MyStack stack;

    @Before
    public void setUp() throws Exception {
        stack = new MyStack();
    }

    @Test
    public void testPush() {
        stack.push(5);
        assertEquals("Stack.push does not work properly", 5, stack.peek());
        stack.push(7);
        assertEquals("Stack.push does not work properly", 7, stack.peek());
    }

    @Test
    public void testCapacityIncrement() {
        for(int i = 0; i < 30; i++) {
            stack.push(i);
        }
        assertThat(30, is(stack.size()));
    }

    @Test
    public void testPop() {
        stack.push(5);
        assertEquals("Stack.pop does not work properly", 5, stack.pop());
    }

    @Test
    public void testPopLargeStack() {
        for(int i = 0; i < 30; i++) {
            stack.push(i);
        }
        for(int i = 0; i < 30; i++) {
            stack.pop();
        }
        assertEquals("Stack.pop does not work properly", 0, stack.size());
    }

    @Test
    public void testPeek() {
        stack.push(5);
        assertEquals("Stack.peek does not work properly", 5, stack.peek());
        for(int i = 0; i < 30; i++) {
            stack.push(i);
        }
        for(int i = 0; i < 30; i++) {
            stack.peek();
        }
        assertEquals("Stack.peek does not work properly", 29, stack.peek());
    }



    @Test
    public void testSize() {
        assertEquals("Stack.size doesn't work properly",0, stack.size());
    }
}
