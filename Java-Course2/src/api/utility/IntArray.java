package api.utility;

import java.util.Arrays;

public class IntArray {
    private static final int DEFAULT_CAPACITY = 5;
    private int[] elements;
    private int size = 0;

    public IntArray() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    // 얻는 동작
    public int get(int index) {
        // index 체크
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("범위 초과");
        }
        return elements[index];
    }

    // 저장
    public void add(int element) {
        if (size==elements.length) {
            ensureCapacity();
        } else {
            elements[size++] = element;
        }
    }

    private void ensureCapacity() {
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements,newCapacity);
    }


}
