package database.com.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T,ID> extends Repository<T,ID> {

    // create = C , Update = U
    T save(T data);

    // read = Rw
   Optional<T> findById(ID id); //한개만 읽기

   List<T> findAll(); //여러개 읽기

   // Delete = D
    void delete(ID id);

}
