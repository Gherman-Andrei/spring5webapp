package andrei.gherman.spring5webapp.repositories;

import andrei.gherman.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
