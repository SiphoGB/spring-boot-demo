package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.Topic;

public interface TopicResource extends CrudRepository<Topic, Long> {

}
