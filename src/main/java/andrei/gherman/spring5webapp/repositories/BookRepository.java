package andrei.gherman.spring5webapp.repositories;

import andrei.gherman.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
