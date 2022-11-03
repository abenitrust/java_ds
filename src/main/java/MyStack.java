import java.util.EmptyStackException;

public class MyStack {
    private int top = -1;
    private Object[] stackArray;
    private int capacity = 10;

    public MyStack(int capacity) {
        this.capacity = capacity;
        stackArray = new Object[capacity];
    }

    public MyStack() {
        this(10);
        this.capacity = 10;
    }

    public int size() {
        return top + 1;
    }

    public Object peek() throws EmptyStackException {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Object value) {
        if(top + 1 >= capacity) {
            doubleCapacity();
        }
        stackArray[++top] = value;
    }

    public Object pop() throws EmptyStackException{
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        Object result = stackArray[top];
        return stackArray[top--];
    }

    public void doubleCapacity() {
        Object[] doubleArray = new Object[capacity*2];
        for(int i=0; i < stackArray.length; i++) {
            doubleArray[i] = stackArray[i];
        }
        stackArray = doubleArray;
        capacity *= 2;
    }


}
