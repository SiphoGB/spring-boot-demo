package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.UserTopic;

public interface UserTopicResource extends CrudRepository<UserTopic, Long> {

}
