package database.com.book.repository;

import database.com.book.entity.BookEntity;
import database.com.db.SimpleDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository extends SimpleDataRepository<BookEntity,Long> {
}
