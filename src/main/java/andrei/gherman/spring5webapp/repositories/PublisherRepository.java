package andrei.gherman.spring5webapp.repositories;

import andrei.gherman.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository  extends CrudRepository<Publisher,Long> {
}
