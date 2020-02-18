package com.simongirard.innso.repositories;

import com.simongirard.innso.model.CustomerFile;
import org.springframework.data.repository.CrudRepository;

public interface CustomerFileRepository extends CrudRepository<CustomerFile, Long> {
    CustomerFile findByReference(String reference);

    CustomerFile findByClientName(String clientName);
}
