package api.utility;

import java.util.Arrays;

public class ObjectArray {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements; // 다형성 배열
    private int size = 0;

    public int size() {
        return size;
    }

    public ObjectArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object object) {
        if (size==elements.length) {
            ensureCapacity();
        }
        elements[size++] = object;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements,newCapacity);
    }

    public Object get(int index) {
        return elements[index];
    }
}
