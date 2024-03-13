package api.utility;

import java.awt.print.Book;
import java.util.Arrays;

public class BookArray {
    private static final int DEFAULT_CAPACITY = 5;
    private BookDTO[] elements;
    private int size = 0;

    public BookArray() {
        elements = new BookDTO[DEFAULT_CAPACITY];
    }

    public void add(BookDTO bookDTO) {
        if (size==elements.length) {
            ensureCapacity();
        }
        elements[size++] = bookDTO;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements,newCapacity);
    }

    public BookDTO get(int index) {
        return elements[index];
    }

}
