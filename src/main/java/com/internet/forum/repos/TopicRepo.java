package com.internet.forum.repos;

import com.internet.forum.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepo extends CrudRepository<Topic, Long> {

    List<Topic> findByName(String name);

}
