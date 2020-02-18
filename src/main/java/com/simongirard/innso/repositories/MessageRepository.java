package com.simongirard.innso.repositories;

import com.simongirard.innso.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    Message findByAuthorName(String authorName);
}
