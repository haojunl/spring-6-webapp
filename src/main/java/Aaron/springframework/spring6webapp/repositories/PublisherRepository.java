package Aaron.springframework.spring6webapp.repositories;

import Aaron.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Aaron
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
