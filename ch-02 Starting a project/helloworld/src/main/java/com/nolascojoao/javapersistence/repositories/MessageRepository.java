package com.nolascojoao.javapersistence.repositories;

import com.nolascojoao.javapersistence.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
