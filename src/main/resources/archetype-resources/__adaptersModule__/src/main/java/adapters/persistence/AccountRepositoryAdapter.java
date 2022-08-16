package ${package}.adapters.persistence;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepositoryAdapter extends CrudRepository<AccountRecord, String> {

}
