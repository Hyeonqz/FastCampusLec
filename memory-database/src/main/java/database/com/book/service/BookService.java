package database.com.book.service;

import database.com.book.entity.BookEntity;
import database.com.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    //원래는 아래 생성자가 있어야함 그러나 지금은 롬복 @RequiredArgsConstructor이 해결해준다.
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // create, update
    public BookEntity create(BookEntity book) {
        return bookRepository.save(book);
    }

    // all
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }


}
